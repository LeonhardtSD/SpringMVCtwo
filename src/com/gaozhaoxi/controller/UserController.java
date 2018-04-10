package com.gaozhaoxi.controller;

import com.gaozhaoxi.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    //静态List<User>集合，此处代替数据库用来保存注册的用户信息
    private  static List<User> userlist;

    public UserController(){
        super();
        userlist=new ArrayList<User>();
    }

    //静态日志类LogFactory
    private static final Log logger= LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerForm(){
        logger.info("register GET 方法调用");
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username) {
            logger.info("register Post方法被调用....");

            User user=new User();
            user.setLoginname(loginname);
            user.setPasswords(password);
            user.setUsername(username);

            //模拟数据库存储user信息
            userlist.add(user);

            return "loginForm";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String password,
                        Model model){
            logger.info("登录名："+loginname+"  密码："+password);

            //到集合中验证用户是否存在，模拟数据库验证
            for (User user:userlist){
                if(user.getLoginname().equals(loginname)&&user.getPasswords().equals(password)){
                    model.addAttribute("user",user);
                    return "welcome";
                }
            }
            return "loginForm";
    }


}
