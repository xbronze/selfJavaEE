package com.dingli.miniprogram.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xbronze
 * @date: 2024-10-21 21:29
 * @description: TODO
 */
@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private IFileService iFileService;

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile file, HttpServletRequest request) {

        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file, path);

        String url = "http://192.168.72.133:8089/" + targetFileName;

        Map<String, Object> fileMap = new HashMap<>();
        fileMap.put("uri", targetFileName);
        fileMap.put("url", url);
        return fileMap;
    }
}
