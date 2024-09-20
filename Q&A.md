

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



## Spring getBean() 方式获取接口实现类的实例化对象，报错：Exception in thread "main" org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'productImpl' is expected to be of type 'com.dingli.chapter4.xmlconfig.service.impl.ProductImpl' but was actually of type 'jdk.proxy2.$Proxy3'

待补充...



## Spring版本与Tomcat版本说明

![微信截图 20240909100904](https://img.picgo.net/2024/09/09/_20240909100904d33d770d1bffe101.jpeg)

上面的错误，是因为把项目中引入的`jakarta.servlet-api`依赖，强制更换为`javax.servlet-api`造成的。

```xml

<!--        <dependency>-->
<!--            <groupId>jakarta.servlet</groupId>-->
<!--            <artifactId>jakarta.servlet-api</artifactId>-->
<!--            <version>6.1.0</version>-->
<!--            <scope>provided</scope>-->
<!--        </dependency>-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
    </dependency>

```

`DispatcherServlet`控制器类是由`spring-webmvc-6.1.6`提供的，而`spring-webmvc-6.1.6`版本对应的是`jakarta`而非`javax`，并且运行所需要的是`Tomcat10`版本，`Tomcat9`版本启动项目，虽然能够启动成功，但是项目所提供的服务接口，浏览器无法访问。

![微信截图 20240909162517](https://img.picgo.net/2024/09/09/_20240909162517a0e9272df12e73ba.jpeg)

> 从 Spring Framework 6.0 开始，Spring 已升级到 Jakarta EE 9 级别（例如 Servlet 5.0、JPA 3.0），基于 jakarta 命名空间而不是传统的 javax 包。由于 EE 9 是最低版本，并且已经支持 EE 10，Spring 准备为 Jakarta EE API 的进一步发展提供开箱即用的支持。Spring Framework 6.0 与 Tomcat 10.1、Jetty 11 和 Undertow 2.3 作为 Web 服务器完全兼容，并且还与 Hibernate ORM 6.1 完全兼容。

**需要注意的是，`spring-webmvc`依赖，即包含了`spring-context`依赖，所以不需要重复引入。**

```xml
<!-- spring-webmvc依赖，即包含了spring-context依赖，所以不需要重复引入 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.6</version>
</dependency>
```



## Maven引入了JSTL标签的依赖，但是项目启动后运行依旧报错`无法在web.xml或使用此应用程序部署的jar文件中解析绝对uri：[http://java.sun.com/jsp/jstl/core]`

pom.xml文件中已经引入依赖

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/taglibs/standard -->
<dependency>
    <groupId>taglibs</groupId>
    <artifactId>standard</artifactId>
    <version>1.1.2</version>
</dependency>
```

JSP文件中也引入了JSTL标签

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

项目运行依旧报错：

![%DISPLAY_TITLE%](https://img.picgo.net/2024/09/19/_20240919091411264cb83270323cba.jpeg)

解决办法（暂行）：

下载所依赖的两个jar包`jstl-1.2.jar`和`standard-1.1.2.jar`，把这两个jar包放到tomcat服务器的lib目录里面