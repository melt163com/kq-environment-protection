package com.demo.login.redirect;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 15015
 * @Auther: TongDeYi
 * @Date: 2022/05/10/15:02
 * @Description:
 */
@Controller
@RequestMapping("/jump")
public class UserInfoRedirect {
    /**
     * todo：测试跳转
     * @return
     */
    @GetMapping("/redirect")
    public String testRedirect(){
        return "index2";
    }

//    /**
//     * todo：测试跳转
//     * @return
//     */
//    @PassToken
//    @GetMapping("/error")
//    public String error(){
//        return "redirect:/error";
//    }

    /**
     * todo：登陆跳转
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * todo：注册跳转
     * @return
     */

    @GetMapping("/register")
    public String register( ){
        return "register";
    }

    /**
     * todo：忘记密码
     * @return
     */
    @GetMapping("/forgetPwd")
    public String forgetPwd(){
        System.out.println("12312312312");
        return "forgetPwd";
    }
}
