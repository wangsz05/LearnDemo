package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class IndexController {
    Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping({"/"})
    public String index(Model model) throws Exception {
        model.addAttribute("message", "CTFers");
        return "index";
    }

    @GetMapping({"/test"})
    @ResponseBody
    public String test() {
        return "This is test demo";
    }

    @GetMapping({"/path"})
    @ResponseBody
    public String fragment(@RequestParam String path) {
        return "welcome :: " + path;
    }

    @GetMapping({"/doc/{data}"})
    public void getData(@PathVariable String data) {
        this.log.info("info: " + data);
    }

    @RequestMapping("/hello")
    public void hello(Map<String, Object> map) {
        //通过 map 向前台页面传递数据
        map.put("name", "编程帮（www.biancheng.net）");
//        return "hello";
    }
}
