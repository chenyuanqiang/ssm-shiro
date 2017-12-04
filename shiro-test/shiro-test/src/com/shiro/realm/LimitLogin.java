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
 *���������û������û���������Ĵ��������޶�
 */
public class LimitLogin  extends HashedCredentialsMatcher{
	private Cache<String, AtomicInteger> passwordRetryCache;
    //����ע�뻺�������
    @Autowired
    private EhCacheManager shiroEhcacheManager;
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		passwordRetryCache = shiroEhcacheManager.getCache("passwordRetryCache_admp");
        //��ȡ�������������������ʱ��
        Long lockTime = shiroEhcacheManager.getCacheManager().getCache("passwordRetryCache_admp").getCacheConfiguration().getTimeToLiveSeconds();
        //��ȡ��¼��
        String username = (String) token.getPrincipal();
        //ʹ��AtomicInteger,�ö���Ϊ�̰߳�ȫ����
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        //����֮���ֵ����������������Ա�,���������5��
        if (retryCount.incrementAndGet() == 5) {
            throw new LockedAccountException("�˻�������,����" + lockTime / 60 + "�ֺ����µ�¼");
        }
        if (retryCount.get() > 5) {
            throw new LockedAccountException("�˻�������");
        }
        boolean matches = super.doCredentialsMatch(token, info);
        //����ȶԳɹ�������û���������������
        if (matches) {
            //clear retry data
            passwordRetryCache.remove(username);
        } else {
            if (5 - retryCount.get() <= 3) {
                throw new ExcessiveAttemptsException("�������,ʣ��" + (5 - retryCount.get()) + "��");
            }
            throw new ExcessiveAttemptsException("�������");
        }
        //���ؽ��Ϊtrue��ʾ��֤ͨ��
        return matches;
	    }
	}


