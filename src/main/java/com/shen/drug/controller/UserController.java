package com.shen.drug.controller;

import com.shen.drug.common.ResultMapUtil;
import com.shen.drug.entity.User;
import com.shen.drug.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Security;

/**
 * 用户相关的controller
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    /**
     * 转向登录页面
     */
    @RequestMapping(value = "/login")
    public String login1(){
        return "/login";
    }

    @RequestMapping(value = "/")
    public String login2(){
        return "/login";
    }
    /**
     * 转向登录页面
     */
    @RequestMapping(value = "/register")
    public String register(){
        return "/registerPage";
    }

    /**
     * 判断用户登录是否成功
     */
    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String username,String password){
        if(username==null||password==null){
            return ResultMapUtil.getHashMapLogin("用户名密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResultMapUtil.getHashMapLogin("用户名不存在","2");
        }catch (IncorrectCredentialsException e){
            return ResultMapUtil.getHashMapLogin("密码错误","2");
        }
        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }

    /**
     * 转向后台管理首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }

    /**
     * 退出登录
     */

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/toRegister")
    @ResponseBody
    public Object toRegister(User user){
        try {
            int i = userService.addUser(user);
            if (i==0){
                return ResultMapUtil.getHashMapLogin("注册成功","1");
            }else{
                return ResultMapUtil.getHashMapLogin("注册失败，用户已存在","2");
            }
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

