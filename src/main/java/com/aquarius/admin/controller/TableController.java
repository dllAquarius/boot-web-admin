package com.aquarius.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 */
@Controller
public class TableController {

    @GetMapping("basic_table")
    public String basic_table(){
        int a= 1/0;
        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(){
        return "table/dynamic_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
