package com.example.reserial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Base64;


@Controller
public class IndexController {

    @RequestMapping("/")
        public String index() {
            return "index";
        }

    @RequestMapping("/readObject")
    public String readObject(@RequestParam(name = "data", required = true)String data, Model model) throws IOException, ClassNotFoundException {

        byte[] bytes =base64Decode(data);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        objectInputStream.readObject();
        return "index";
    }

    public static byte[] base64Decode(String data) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(data);
    }

}
