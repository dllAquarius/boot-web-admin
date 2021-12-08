package com.aquarius.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/8
 * @Description:
 */
@Slf4j
@Controller
public class FileController {

    @GetMapping("form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photo
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public String upload(@RequestParam("email") String email
            , @RequestParam("username") String username
            , @RequestPart("headerImg") MultipartFile headerImg
            , @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传信息：email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);

        if (!headerImg.isEmpty()){
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\project\\file\\"+filename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\project\\file\\"+filename));
                }
            }
        }

        return "main";
    }
}
