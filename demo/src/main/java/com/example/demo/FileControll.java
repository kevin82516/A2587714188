//package com.example.demo;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//public class FileControll {
//
//    @Value("${filePath}")
//    private String filePath;
//
//    @GetMapping("/upload")
//    public String uploading() {
//        return "inputfile";
//    }
//
//    @PostMapping("/inputfile")
//    public @ResponseBody String uploading(@RequestParam("file") MultipartFile file,
//                                          HttpServletRequest request) {
//        try {
//            uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("文件上傳失敗!");
//            return "uploading failure";
//        }
//        System.out.println("文件上傳成功!");
//        return "uploading success";
//    }
//
//
//
//    public void  uploadFile(byte[] file, String filePath, String fileName) throws Exception {
//        File targetFile = new File(filePath);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        FileOutputStream out = new FileOutputStream(filePath+fileName);
//        out.write(file);
//        out.flush();
//        out.close();
//    }
//
//}
