package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.result.Result;

public interface KWICService {
    public Result<String> process(MultipartFile file);
}
