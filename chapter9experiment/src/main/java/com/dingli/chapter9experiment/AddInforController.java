package com.dingli.chapter9experiment;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/system")
public class AddInforController {

    @RequestMapping("/showInfor")
    public ModelAndView showInfor(Student student, HttpServletRequest request) {
        MultipartFile file = student.getPhoto();
        String originalFilename = file.getOriginalFilename();
        //获取文件保存在服务器中的文件夹路径
        String path = request.getServletContext().getRealPath("/images/");
        //设置图片保存到服务器的目标路径
        String filePath = path + originalFilename;
        try {
            file.transferTo(new File(filePath));	//保存图片到目标路径
        } catch (IOException e) {
            System.out.println("保存图片失败！");
        }

        //设置student的requestPath和photoName属性
        student.setRequestPath(filePath);
        student.setPhotoName(originalFilename);
        //创建ModelAndView类对象
        ModelAndView modeAndView = new ModelAndView();
        //在ModelAndView类对象中添加名称为student的数据
        modeAndView.addObject("student", student);
        //在ModelAndView类对象中设置视图名称为showInfor
        modeAndView.setViewName("showInfor");
        return modeAndView;
    }
    //下载文件方法
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, String fileName)
            throws IOException {
        //获取下载文件的路径
        String filePath = request.getServletContext().getRealPath("/images/") + fileName;
        //创建该文件的对象
        File file = new File(filePath);
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