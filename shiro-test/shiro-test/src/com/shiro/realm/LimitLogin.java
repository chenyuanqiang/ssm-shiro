package com.shiro.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author cyq
 *用来锁定用户，当用户密码输入的次数超过限定
 */
public class LimitLogin  extends HashedCredentialsMatcher{
	private Cache<String, AtomicInteger> passwordRetryCache;
    //依赖注入缓存管理器
    @Autowired
    private EhCacheManager shiroEhcacheManager;
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		passwordRetryCache = shiroEhcacheManager.getCache("passwordRetryCache_admp");
        //获取密码错误次数缓存对象存活时间
        Long lockTime = shiroEhcacheManager.getCacheManager().getCache("passwordRetryCache_admp").getCacheConfiguration().getTimeToLiveSeconds();
        //获取登录名
        String username = (String) token.getPrincipal();
        //使用AtomicInteger,该对象为线程安全对象
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        //自增之后的值和最大密码错误次数对比,最大错误次数5次
        if (retryCount.incrementAndGet() == 5) {
            throw new LockedAccountException("账户被锁定,请于" + lockTime / 60 + "分后重新登录");
        }
        if (retryCount.get() > 5) {
            throw new LockedAccountException("账户被锁定");
        }
        boolean matches = super.doCredentialsMatch(token, info);
        //密码比对成功清除该用户密码错误次数缓存
        if (matches) {
            //clear retry data
            passwordRetryCache.remove(username);
        } else {
            if (5 - retryCount.get() <= 3) {
                throw new ExcessiveAttemptsException("密码错误,剩余" + (5 - retryCount.get()) + "次");
            }
            throw new ExcessiveAttemptsException("密码错误");
        }
        //返回结果为true表示验证通过
        return matches;
	    }
	}


