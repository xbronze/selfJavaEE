

## Tomat9访问时被要求输入用户和密码

为了在Tomcat 9中设置访问需要密码的基本认证，你需要进行以下步骤：

1.  打开Tomcat的安装目录，找到`conf`文件夹。
2.  编辑`tomcat-users.xml`文件，该文件位于`conf`文件夹中。
3.  添加或修改一个用户，指定角色和密码。例如：

```xml
<tomcat-users>
  <role rolename="manager-gui"/>
  <user username="admin" password="yourpassword" roles="manager-gui"/>
</tomcat-users>
```

保存tomcat-users.xml文件。

重启Tomcat服务器。
