package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.result.Result;
import com.example.demo.service.KWICService;

@RestController
public class KWICController {
    @Autowired
    private KWICService kwicService;

    @PostMapping("/process")
    public Result<String> process(@RequestParam("file") MultipartFile file){
        return kwicService.process(file);
    }
}
