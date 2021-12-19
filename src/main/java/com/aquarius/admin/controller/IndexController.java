package com.aquarius.admin.controller;

import com.aquarius.admin.bean.Account;
import com.aquarius.admin.bean.City;
import com.aquarius.admin.bean.User;
import com.aquarius.admin.servlet.AccountService;
import com.aquarius.admin.servlet.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate                              jdbcTemplate;
    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("addCity")
    public City addCity(City city){
        cityService.addCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/getCityById")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/getAccount")
    public Account getAccount(@RequestParam("id") Long id){
        Account account = accountService.getAccount(id);
        log.info(account.toString());
        return account;

    }
    @ResponseBody
    @GetMapping("/sql")
    public String queryForDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_account", Long.class);
        return aLong.toString();
    }

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
