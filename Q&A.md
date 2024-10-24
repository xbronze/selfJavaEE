

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



## 访问Spring MVC接口，浏览器报错：406 根据请求中接收到的主动协商头字段，目标资源没有用户代理可以接受的当前表示，而且服务器不愿意提供缺省表示。

![微信截图 20241021113954](https://img.picgo.net/2024/10/21/_2024102111395494e13c4a25e76e55.jpeg)



**406错误的核心原因**‌是根据请求中接收到的主动协商头字段，目标资源没有用户代理可以接受的当前表示，并且服务器不愿意提供默认表示‌。

**常见原因及解决方案**‌：

1. **请求地址后缀问题**‌：确保请求地址的后缀正确，不要写成.html而不写成.json或其他正确的格式‌。
2. **缺少转换依赖**‌：添加依赖
```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.2</version>
</dependency>
```
3. **配置问题**‌：在配置文件中添加`<mvc:annotation-driven />`。

## 安全性、客户端无法访问

在Java Web项目中，js文件不能放在WEB-INF目录下的主要原因是为了安全性。WEB-INF目录是Java Web应用的安全目录，其主要目的是限制外部访问，保护应用的安全。具体来说，WEB-INF目录下的资源文件对客户端是不可见的，客户端无法直接访问到这个目录下的文件‌。

为什么不能放在WEB-INF目录下
‌安全性‌：WEB-INF目录下的资源文件（如js、css、images等）对客户端是不可见的，这样可以防止外部用户直接访问这些文件，从而提高应用的安全性‌12。
‌访问限制‌：客户端无法直接通过URL访问WEB-INF目录下的文件。例如，如果尝试通过超链接或JavaScript的location.href属性直接转向到WEB-INF下的页面，这些请求会被服务器拒绝，因为这些请求是客户端发起的‌。
替代方案
为了在Web应用中安全地使用js文件，可以将js文件放在Web应用的公共目录下，如WebRoot或webapp目录。这样，客户端可以正常访问这些文件，同时应用的安全性也不会受到影响‌。

通过以上解释，可以更好地理解为什么在Java Web项目中js文件不能放在WEB-INF目录下，以及如何安全地使用这些文件。