package com.aquarius.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/8
 * @Description:
 */
@Controller
public class FileController {

    @GetMapping("form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
}
