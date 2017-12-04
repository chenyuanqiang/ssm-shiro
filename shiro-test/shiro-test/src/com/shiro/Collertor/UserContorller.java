package com.shiro.Collertor;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiro.model.User;
import com.shiro.service.UserService;

@Controller
@RequestMapping("user")
public  class UserContorller {
	@Autowired
	UserService userService;
	@RequestMapping("login")
	public String login(User u){
		User user=userService.loginByName(u.getLoginName());
		UsernamePasswordToken token = null;
		if(user!=null){
			Subject subject = SecurityUtils.getSubject();
			token = new UsernamePasswordToken(u.getLoginName()
					,u.getPassword());
			if(!subject.isAuthenticated()){
				token.setRememberMe(true);
				subject.login(token);
				
				return "index";
			}else{
				return "list";
			}
			
		}
			return "login";
		
	}
	public class ReqUser{
		private String loginName;
		private String password;
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
}
