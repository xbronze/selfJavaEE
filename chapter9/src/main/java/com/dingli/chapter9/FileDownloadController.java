package com.dingli.chapter9;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author: xbronze
 * @date: 2024-10-04 21:53
 * @description: TODO
 */
@Controller
@RequestMapping("/file")
public class FileDownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String fileName) throws IOException {
        //获取下载文件的路径
        String filepath = request.getServletContext().getRealPath("/upload/") + fileName;
        //创建该文件的对象
        File file = new File(filepath);
        //将文件读取到字节数组中
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //创建HttpHeaders对象设置响应头信息
        HttpHeaders headers = new HttpHeaders();
        //设置浏览器以“UTF-8”编码方式显示文件名
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置以下载的方式打开文件，并指定文件名称
        headers.setContentDispositionFormData("attachment", fileName);
        //设置文件的下载方式为二进制流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);

    }

}
