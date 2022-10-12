package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.methods.method_one.KWIC;
import com.example.demo.result.Result;
import com.example.demo.service.KWICService;
@Service
public class KWICServiceImpl implements KWICService{

    public static void main(String[] args) throws IOException{

    }

    @Override
    public Result<String> process(MultipartFile file) {
        try {
            File f = new File("D:\\CodeFiled\\Java_Single\\work_project\\demo\\src\\main\\java\\com\\example\\demo\\methods\\method_one\\", "input.txt");
            file.transferTo(f);


        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return KWIC.process();
    }
    
}
