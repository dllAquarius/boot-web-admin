package com.aquarius.admin.controller;

import com.aquarius.admin.bean.User;
import com.aquarius.admin.servlet.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("basic_table")
    public String basic_table() {
        int a = 1 / 0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes redirectAttributes){

        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn" ,defaultValue = "1")Integer pn, Model model) {
        List<User> list = userService.list();
        // model.addAttribute("users", list);
        // 分页查询数据
        Page<User> page = new Page<>(pn, 2);
        // 分页查询的结果
        Page<User> userPage = userService.page(page, null);
        if (userPage.getRecords().size()==0&&pn!=1){
            pn = pn-1;
            page = new Page<>(pn, 2);
            // 分页查询的结果
            userPage = userService.page(page, null);
        }
        model.addAttribute("page",userPage);
        return "table/dynamic_table";
    }

    @GetMapping("editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
}
