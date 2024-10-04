package com.dingli.chapter9;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public String fileUpload(ArrayList<MultipartFile> uploadfiles, HttpServletRequest request) {
        if (uploadfiles == null || uploadfiles.size() == 0) {
            return "fileUpload";
        }
        ArrayList<String> msgs = new ArrayList<>();
        for (MultipartFile file : uploadfiles) {
            if (!file.isEmpty() || file.getSize() > 0) {
                // 获取文件的原始名称
                String fileName = file.getOriginalFilename();
                // 获取服务器中的文件夹路径
                String path = request.getServletContext().getRealPath("/upload/");
                // 设置文件保存到服务器上的位置
                String filePath = path + fileName;
                try {
                    // 保存文件的内容到目标服务器
                    file.transferTo(new File(filePath));
                } catch (IOException e) {
                    msgs.add(filePath + " 保存失败");
                }
                msgs.add(filePath + " 保存成功");
            }
        }
        request.setAttribute("msgs", msgs);
        return "fileUpload";
    }
}