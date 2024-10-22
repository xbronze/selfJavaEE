package com.dingli.miniprogram.file;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {

    private String ip;
    private int port;
    private String user;
    private String pwd;
    private static FTPClient ftpClient;
    public static FileInputStream fis;

    private static String ftpIp = "192.168.72.133";
    private static String ftpPort = "2121";
    private static String ftpUser = "ftpuser";
    private static String ftpPass = "ftppasswd";
    private static String ftpPath = "/home/ftpuser/images";

    public FTPUtil(String ip, int port, String user, String pwd){
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, Integer.valueOf(ftpPort), ftpUser, ftpPass);

        //TODO 改成logger日志记录
        System.out.println("开始连接ftp服务器");
        boolean result = true;
        try {
            result = ftpUtil.uploadFile(ftpPath, fileList);
        } catch (IOException e) {
            //TODO 改成logger日志记录
            result = false;
            System.out.println("上传文件异常:" + e.getMessage());
            e.printStackTrace();
        } finally {
            if(fis != null)
                fis.close();
            if(ftpClient != null)
                ftpClient.disconnect();
        }
        //TODO 改成logger日志记录
        System.out.println("结束上传,上传结果:【" + result + "】");
        return result;
    }


    private boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        //连接FTP服务器
        if(connectFtpServer(this.ip, this.port, this.user, this.pwd)){
            ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.enterLocalPassiveMode();
            for(File fileItem : fileList){
                fis = new FileInputStream(fileItem);
                ftpClient.storeFile(fileItem.getName(),fis);
            }
        }
        return true;
    }

    private boolean connectFtpServer(String ip,int port,String user,String pwd) throws IOException {
        ftpClient = new FTPClient();
        ftpClient.connect(ip, port);
        ftpClient.login(user, pwd);
        ftpClient.setConnectTimeout(5000);
        ftpClient.setControlEncoding("UTF-8");
        ftpClient.setBufferSize(1024);
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            System.out.println("未连接到FTP，用户名或密码错误");
            ftpClient.disconnect();
            return false;
        }
        return true;

    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

}
