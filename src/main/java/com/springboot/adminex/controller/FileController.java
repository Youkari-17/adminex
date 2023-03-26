package com.springboot.adminex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//测试文件上传
@Slf4j
@Controller
public class FileController {
    @RequestMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("username") String username, @RequestParam("email") String email,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("email={},username={},headerImg={},photos={}", email, username, headerImg.getSize(), photos.length);
        String headerImgFilename = UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + headerImg.getOriginalFilename();
        if (!headerImg.isEmpty()) {
            headerImg.transferTo(new File("F:\\Picture\\uploadtest\\" + headerImgFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String photoImgFilename = UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\Picture\\uploadtest\\" + photoImgFilename));
                }
            }
        }
        return "redirect:index";
    }
}
