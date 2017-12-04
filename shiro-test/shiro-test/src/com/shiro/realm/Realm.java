package com.shiro.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.shiro.model.User;
import com.shiro.service.UserService;

public class Realm extends AuthorizingRealm{
    @Autowired
    UserService UserService;
    @Autowired 
    private EhCacheManager shiroEhcacheManager;
    @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken uptoken=(UsernamePasswordToken)arg0;
		String name=uptoken.getUsername();
		 Cache passwordRetryCache = shiroEhcacheManager.getCache("passwordRetryCache_admp");
		    @SuppressWarnings("unchecked")
			AtomicInteger retryCount = (AtomicInteger) passwordRetryCache.get("username");
		    if (null != retryCount && retryCount.get() > 5) {
		        throw new LockedAccountException("ÕË»§±»Ëø¶¨");
		    }
		    User u=UserService.loginByName(name); 
		return  new SimpleAuthenticationInfo(name,u.getPassword()
				,ByteSource.Util.bytes(name), getName());
	}
public static void main(String[] args) {
	String hashAlgorithmName = "MD5";
	Object credentials = "123456";
	Object salt = ByteSource.Util.bytes("admin");;
	int hashIterations = 1024;
	
	Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
	System.out.println(result);

}
}
