package com.aquarius.admin.controller;

import com.aquarius.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 */
@Controller
public class IndexController {


    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (StringUtils.hasLength(user.getUserName())&&StringUtils.hasLength(user.getPassword())){
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            // 登录成功重定向到main.html  防止表单重新提交，重定向
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号密码错误");
        // 登录失败返回登录页面
        return "login";
    }


    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser !=null){
//            return "main";
//        }
//        model.addAttribute("msg","请重新登录");
        return "main";
    }
}
