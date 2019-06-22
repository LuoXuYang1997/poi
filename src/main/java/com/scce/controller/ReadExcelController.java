package com.scce.controller;

import com.scce.utils.ReadExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-21 20:58
 **/

@Controller
public class ReadExcelController {
    @ResponseBody
    @RequestMapping("/UploadTheme")//上传主题
    public List<String[]> UploadTheme(MultipartFile meFile) throws Exception {
        List<String[]> list = null;
        if (meFile != null) {
            System.out.println(meFile.getContentType());//在控制台打印文件的类型
            System.out.println(meFile.getName());//返回文件的名称
            System.out.println(meFile.getOriginalFilename());//返回文件的原文件名
            list = ReadExcel.readExcel(meFile);
            for (String[] strings : list) {
                for (int i = 0; i < strings.length; i++) {
                    String string = strings[i];
                    System.out.println(string);
                }
            }
            try {
                meFile.transferTo(new File("D:/java/" + UUID.randomUUID() + meFile.getOriginalFilename()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
