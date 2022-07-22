package com.my.upload.crontroller;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RequestMapping("/file")
@Controller
public class fileCrotroller {

    @RequestMapping("/fileupload")
    public String fileupload02(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("spring MVC方式文件上传已执行");
        String path = "F:\\temp\\fileupload\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        String name = upload.getOriginalFilename();
        System.out.println("====================================");
        System.out.println(name);
        System.out.println("====================================");
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        name = uuid + "_" + name;
        upload.transferTo(new File(path, name));

        return "success";
    }
    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver getStandardServletMultipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
