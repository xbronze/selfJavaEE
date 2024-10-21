## 笔记

### Java SE和Java EE的联系和区别？

- Java SE（Java Platform，Standard Edition）: Java 平台标准版，Java 编程语言的基础，它包含了支持 Java 应用程序开发和运行的核心类库以及虚拟机等核心组件。Java SE 可以用于构建桌面应用程序或简单的服务器应用程序。

- Java EE（Java Platform, Enterprise Edition ）：Java 平台企业版，建立在 Java SE 的基础上，包含了支持企业级应用程序开发和部署的标准和规范（比如 Servlet、JSP、EJB、JDBC、JPA、JTA、JavaMail、JMS）。 Java EE 可以用于构建分布式、可移植、健壮、可伸缩和安全的服务端 Java 应用程序，例如 Web 应用程序。

简单来说，Java SE 是 Java 的基础版本，Java EE 是 Java 的高级版本。Java SE 更适合开发桌面应用程序或简单的服务器应用程序，Java EE 更适合开发复杂的企业级应用程序或 Web 应用程序。

除了 Java SE 和 Java EE，还有一个 Java ME（Java Platform，Micro Edition）。Java ME 是 Java 的微型版本，主要用于开发嵌入式消费电子设备的应用程序，例如手机、PDA、机顶盒、冰箱、空调等。Java ME 无需重点关注，知道有这个东西就好了，现在已经用不上了。

### Spring的分层结构如何理解？

Spring框架的分层结构是指将应用程序按照不同的功能和职责划分成不同的层次，每一层都有特定的功能和责任，各层之间通过定义清晰的接口和协议进行通信，以实现代码的解耦和扩展性的提高。

在Spring框架中，经常使用的分层结构通常包括以下几个层次：

- 展示层（Presentation Layer）：展示层主要负责处理用户的请求和响应，包括用户界面的展示和与用户的交互。在Spring框架中，展示层通常使用Spring MVC模块，通过控制器和视图来完成请求的处理和结果的展示。

- 业务逻辑层（Business Layer）：业务逻辑层是应用程序的核心，负责处理业务流程和逻辑。该层通常包括一些服务类，用于组织和处理关键的业务逻辑。在Spring框架中，业务逻辑层可以使用Spring的依赖注入和声明式事务管理等特性来提高代码的可维护性和可测试性。

- 数据访问层（Data Access Layer）：数据访问层用于处理与数据库或其他持久化存储相关的操作。该层主要负责数据库的连接、查询、更新等操作，并将结果返回给业务逻辑层。在Spring框架中，可以使用Spring的JdbcTemplate或者Hibernate等ORM框架来简化数据访问层的开发。

- 基础设施层（Infrastructure Layer）：基础设施层用于提供一些基础的支持和服务，例如日志、缓存、消息队列等。该层的主要功能是为其他层提供便利和增强，以提高应用程序的性能和可靠性。在Spring框架中，可以使用Spring的AOP功能来实现基础设施层的功能。

通过将应用程序划分成不同的层次，可以使代码更加模块化和可维护，不同的层级之间通过接口进行通信，降低了各层之间的耦合度，以便于扩展和修改。同时，Spring框架提供了丰富的功能和特性，可以简化每个层的开发和配置，提高开发效率。



### 声明式事务

声明式事务(declarative transaction management)是Spring提供的对程序事务管理的方式之一。

Spring的声明式事务顾名思义就是采用声明的方式来处理事务。这里所说的声明，就是指在配置文件中声明。用在Spring配置文件中声明式的处理事务来代替代码式的处理事务。这样的好处是，事务管理不侵入开发的组件，具体来说，业务逻辑对象就不会意识到正在事务管理之中，事实上也应该如此，因为事务管理是属于系统层面的服务，而不是业务逻辑的一部分，如果想要改变事务管理策划的话，也只需要在定义文件中重新配置即可；在不需要事务管理的时候，只要在设定文件上修改一下，即可移去事务管理服务，无需改变代码重新编译，这样维护起来极其方便。


### `@PostConstruct`注解

#### 1.**定义和基本用法**

在Java EE规范中，`@PostConstruct`注解被定义为一个元注解，它被用于标记一个方法，该方法将在bean的依赖注入完成之后被调用。该方法没有参数，返回值类型可以是void或任意其他类型。

`@PostConstruct`注解的实现可以追溯到Java EE规范中的`javax.annotation`包。具体而言，`@PostConstruct`注解的定义位于`javax.annotation`包中的`javax.annotation.PostConstruct`接口中。该接口只有一个方法，即`void postConstruct()`。

在Java EE容器中，当一个bean被创建并且所有的依赖注入完成之后，容器将检查该bean是否使用了`@PostConstruct`注解。如果是，容器将调用该bean中标记了`@PostConstruct`注解的方法。

```java
@PostConstruct
public void init() {
    System.out.println("Bean初始化后，调用init()方法");
}
```

在上面的例子中，`init`方法会在bean实例化后被立即调用。

`@PostConstruct`注解的实现原理是在Spring容器初始化时，会扫描所有标有该注解的方法，并调用它们。因此，`@PostConstruct`注解的方法必须是非静态的，并且可以访问Spring容器中的其他bean实例。

需要注意的是，`@PostConstruct`注解的方法执行顺序与bean实例化的顺序无关，因此需要根据实际情况来确定方法的执行顺序。

#### 2.注意事项

- `@PostConstruct`注解的方法不能有参数，且必须是非静态的。

- `@PostConstruct`注解的方法可以有任何访问修饰符，比如public，private等。

- 如果一个类中存在多个`@PostConstruct`注解的方法，这些方法的执行顺序是不确定的。

- 如果在一个bean类中同时使用了`@Autowired`和`@PostConstruct`注解，那么`@Autowired`注解的方法会在`@PostConstruct`注解的方法之前执行。

- `@PostConstruct`注解的方法不能在非单例的Bean上使用。因为非单例bean在初始化时，在一个线程中，容易出现线程安全问题。

#### 3.总结

总结起来，`@PostConstruct`注解是Java EE规范中的一部分，用于在bean的依赖注入完成之后执行特定的方法。在源码级别，容器通过使用反射机制来调用标记了`@PostConstruct`注解的方法。在实际应用中，我们可以使用`@PostConstruct`注解来执行初始化逻辑，提高应用程序的可靠性和可维护性。



### `@PostConstruct`与`@PreDestroy`注解

`@PostConstruct` 和`@ PreDestory `是两个作用于Servlet生命周期的注解。被这两个注解修饰的方法可以保证在整个Servlet生命周期只被执行一次，即使Web容器在其内部中多次实例化该方法所在的bean

这两个注解分别由什么作用呢？
1、`@PostContruct`： 用来修饰方式，标记在项目启动的时候执行整个方法，一般用来执行某些初始化操作，比如全局配置。`@PostContruct`注解的方法会在构造函数之后执行Servlet的`init()`方法之前执行

2、`@PreDestory`：当bean被Web容器销毁的时候调用，一般用来释放bean所持有的资源。`@PreDestroy`注解的方法会在Servlet的`destory()`方法之前执行。

被这个注解修饰的方法需要满足下面这些基本条件：
1、非静态
2、该方法没有任何参数，除非在拦截器的情况下，在这种情况下，它接收一个由拦截器规范定义的`InvocationContext`对对象
3、void()也就是没有返回值
4、该方法抛出未检查的异常





## 第三章 Spring Bean管理

### Spring Bean两种作用域的对比

Spring Bean比较常用的是singleton和prototype两种作用域。对于singleton作用域的Bean，每次请求该Bean都将获得相同的实例。容器负责跟踪Bean实例的状态，负责维护Bean实例的生命周期行为；如果一个Bean被设置成prototype作用域，程序每次请求该id的Bean，Spring都会新建一个Bean实例，然后返回给程序。在这种情况下，Spring容器仅仅使用new 关键字创建Bean实例，一旦创建成功，容器不在跟踪实例，也不会维护Bean实例的状态。

如果不指定Bean的作用域，Spring默认使用singleton作用域。Java在创建Java实例时，需要进行内存申请；销毁实例时，需要完成垃圾回收，这些工作都会导致系统开销的增加。因此，prototype作用域Bean的创建、销毁代价比较大。而singleton作用域的Bean实例一旦创建成功，可以重复使用。因此，除非必要，否则尽量避免将Bean被设置成prototype作用域。



### 添加日志记录功能

#### 添加Log4j2依赖

```xml
<!-- Log4j2依赖-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.23.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j2-impl</artifactId>
            <version>2.23.1</version>
        </dependency>
```





#### 增加配置文件log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <loggers>
        <!--
            level指定日志级别，从低到高的优先级：
                TRACE < DEBUG < INFO < WARN < ERROR < FATAL
                trace：追踪，是最低的日志级别，相当于追踪程序的执行
                debug：调试，一般在开发中，都将其设置为最低的日志级别
                info：信息，输出重要的信息，使用较多
                warn：警告，输出警告的信息
                error：错误，输出错误信息
                fatal：严重错误
        -->
        <root level="DEBUG">
            <appender-ref ref="spring6log"/>
            <appender-ref ref="RollingFile"/>
            <appender-ref ref="log"/>
        </root>
    </loggers>

    
<appenders>
        <!--输出日志信息到控制台-->
        <console name="spring6log" target="SYSTEM_OUT">
            <!--控制日志输出的格式-->
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss SSS} [%t] %-3level %logger{1024} - %msg%n"/>
        </console>

        <!--文件会打印出所有信息，这个log每次运行程序会自动清空，由append属性决定，适合临时测试用-->
        <File name="log" fileName="d:/spring6_log/test.log" append="false">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n"/>
        </File>

        <!-- 这个会打印出所有的信息，
            每次大小超过size，
            则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，
            作为存档-->
        <RollingFile name="RollingFile" fileName="d:/spring6_log/app.log"
                     filePattern="log/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
            <PatternLayout pattern="%d{yyyy-MM-dd 'at' HH:mm:ss z} %-5level %class{36} %L %M - %msg%xEx%n"/>
            <SizeBasedTriggeringPolicy size="50MB"/>
            <!-- DefaultRolloverStrategy属性如不设置， 则默认为最多同一文件夹下7个文件，这里设置了20 -->
            <DefaultRolloverStrategy max="20"/>
        </RollingFile>
    </appenders>
</configuration>

```



## 第四章 Spring AOP

### 依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>6.1.6</version>
        </dependency>
```



### 课后思考（作业）

Spring AOP的实现机制？







## 第五章 Spring数据库编程

### 依赖

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>


<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>6.1.6</version>
</dependency>
```

### bean配置XML

```xml
<!--配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <!--数据库驱动-->
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <!--数据库url-->
        <property name="url" value="jdbc:mysql://localhost:3306/db_spring"/>
        <!--数据库用户名-->
        <property name="username" value="root"/>
        <!--数据库密码-->
        <property name="password" value="123456"/>
    </bean>
    <!--配置JDBC模板-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

```



### 事务的传播行为

[一个视频教会你spring的事务传播行为](https://www.bilibili.com/video/BV1R8411c7m2/?spm_id_from=333.1007.top_right_bar_window_custom_collection.content.click&vd_source=4ab5c676cbad42c66974269867c2b1ee)

```
@Service
public AService A{

	@Autowired
	private BService bservice;
	
	public void test{
		xxxx();
		bservice.aaaa();
		yyyy();
	}
}
```

事务传播行为（propagation behavior）指的就是当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行。

 正常来说有几种解决方案： 

1. 融入事务：直接去掉serviceB中关于开启事务和提交事务的begin和commit，融入到serviceA的事务中。问题：B事务的错误会引起A事务的回滚。 
2. 挂起事务：如果不想B事务的错误引起A事务的回滚，可以开启两个连接，一个执行A一个执行B，互不影响，执行到B的时候把A挂起新起连接去执行B，B执行完了再唤醒A执行。
3. 嵌套事务：MySQL中可以通过给B事务加savepoint和rollback去模拟嵌套事务，把B设置成伪事务。 

spring中的事务传播行为： 

1. PROPAGATION\_REQUIRED（需要）：如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务。（A如果存在事务，则B融入A事务，如果没有则新起一个事务）大部分的修改操作使用 
2. PROPAGATION\_SUPPORTS（支持）：如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。（A有，则B融入，A没有，则非事务执行）大部分的查询操作 
3. PROPAGATION\_MANDATORY（强制性）：如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。（A有，则B融入，A没有，则抛异常） 
4. PROPAGATION\_REQUIRES\_NEW（需要新的）：如果一个事务已经存在，则先将这个存在的事务挂起。如果没有，则新起一个事务执行。（A有，则B挂起执行，A没有则新起一个事务） 
5. PROPAGATION\_NOT\_SUPPORTED（不支持）：总是非事务地执行，并挂起任何存在的事务。（A有，则挂起B非事务执行） 
6. PROPAGATION\_NEVER（从不）：总是非事务地执行，如果存在一个活动事务，则抛出异常。（A有，则抛异常） 7. PROPAGATION\_NESTED（嵌套的）：如果一个活动的事务存在，则运行在一个嵌套的事务中。 如果没有活动事务, 则按TransactionDefinition.PROPAGATION\_REQUIRED 属性执行。（A有，则B用savapoint方式嵌套执行与A）



## 第六章 Spring MVC

### 依赖

```xml

<!-- 把默认添加的jakarta.servlet-api依赖删掉，替换为 javax.servlet-api -->
<dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>



<!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>6.1.6</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>6.1.6</version>
        </dependency>
```



### Spring MVC的工作流程

![spring mvc dispatcher servlet flow compression](https://img.picgo.net/2024/10/16/spring-mvc-dispatcher-servlet-flow-compression02ef51e988c09225.png)

1. 客户端向ｗｅｂ服务器（如tomcat）发送一个http请求，web服务器对http请求进行解析，解析后的url地址如果匹配到DispatchServlet的映射路径（通过web.xml中的servlet-mapping配置），web容器就会将请求交给DispatchServlet处理
2. DispatcherServlet接收到这个请求后，再对URL进行解析，得到请求资源标识符（URI）。然后调用相应方法得到的HandlerMapping对象，再根据URI，调用这个对象的相应方法获得Handler对象以及它对应的拦截器。（在这里只是获得了Handler对象，并不会操作它，在SpringMVC中，是通过HandlerAdapter对Handler进行调用、控制的）
3. DispatcherServlet根据得到的Handler对象，选择一个合适的HandlerAdapter，创建其实例对象，执行拦截器中的preHandler()方法。
4. 在拦截器方法中，提取请求中的数据模型，填充Handler入参，所以所有准备工作都已做好，开始执行Handler（我们写的controller代码并不是能被直接执行，需要有刚才那些操作，才能转变为Handler被执行）。
5. Handler执行完毕后返回一个ModelAndView对象给DispatcherServlet。
6. 这个ModleAndView只是一个逻辑视图，并不是真正的视图，DispatcherServlet通过ViewResolver视图解析器将逻辑视图转化为真正的视图（通俗理解为将视图名称补全，如加上路径前缀，加上.jsp后缀，能指向实际的视图）。
7. DispatcherServlet通过Model将ModelAndView中得到的处数据解析后用于渲染视图。将得到的最终视图通过http响应返回客户端。

## 第七章 数据绑定和请求响应

#### HttpServletRequest的parameter和attribute的区别？


（1）HttpServletRequest类有setAttribute()方法，而没有setParameter()方法

（2）当两个Web组件之间为链接关系时，被链接的组件通过getParameter()方法来获得请求参数，

（3）当两个Web组件之间为转发关系时，转发目标组件通过getAttribute()方法来和转发源组件共享request范围内的数据。

一般通过表单和链接传递的参数使用getParameter

通过request.setAttribute("name","jerry")的方式赋值的使用request.getAttribute("name")

这个问题主要是request和session的差别，request范围较小一些，只是一个请求，简单说就是你在页面上的一个操作， request.getParameter()就是从上一个页面中的url、form中获取参数，但如果一个request涉及多个类，后面还要取参数，可以用request.setAttribute()和request.getAttribute()，但是当结果输出之后，request就结束了。

而session可以跨越很多页面，可以理解是客户端同一个IE窗口发出的多个请求。这之间都可以传递参数，比如很多网站的用户登录都用到了。

一般可以用getParameter得到页面参数。。。字符串。。。

getAttribute()可以得到对象。。。

getParameter可以得到页面传来的参数如？id=123之类的。

getAttribute()常用于servlet页面传递参数给jsp



### mvc:annotation-driven 注解的作用

#### 1.自动注册映射处理器和适配器

这是该注解的主要功能，添加< mvc:annotation-driven/>注解后，容器中会<自动注册HandlerMapping与HandlerAdapter 两个bean。省去手动注册HandlerMapping和HandlerAdapter的步骤。

当配置了< mvc:annotation-driven/>后，Spring就知道了我们启用注解驱动。然后Spring通过< context:component-scan/>标签的配置，会自动为我们将扫描到的@Component，@Controller，@Service，@Repository等注解标记的组件注册到工厂中，来处理我们的请求。

HandlerMapping的实现类的作用：将请求映射到带@RequestMapping注释的控制器方法，将URL路径映射到控制器bean名称。
HandlerAdapter的实现类的作用：实现类RequestMappingHandlerAdapter，处理请求的适配器，确定调用哪个类的哪个方法，并且构造方法参数，返回值。

在spring mvc 3.1以上，DefaultAnnotationHandlerMapping与AnnotationMethodHandlerAdapter对应变更为：
DefaultAnnotationHandlerMapping -> RequestMappingHandlerMapping
AnnotationMethodHandlerAdapter -> RequestMappingHandlerAdapter
AnnotationMethodHandlerExceptionResolver -> ExceptionHandlerExceptionResolver

#### 2.映射异常处理

处理@ExceptionHandler标注的异常处理函数：在dispatcherServlet中，当用户未注册自定义的ExceptionResolver时，自动注册AnnotationMethodHandlerExceptionResolver来对使用@ExceptionHandler标注的异常处理函数进行解析处理(这也导致当用户注册了自定义的exeptionResolver时将可能导致无法处理@ExceptionHandler)。

#### 3.数据校验

官方文档解释：“默认情况下，当在类路径中检测到诸如Hibernate Validator之类的Bean验证提供程序时，使用@EnableWebMvc或<mvc：annotation-driven>会通过LocalValidatorFactoryBean在Spring MVC中自动注册Bean验证支持。”

要实现Hibernate Validator/JSR303 校验（或者其他各种校验），必须实现SpringMVC提供的一个接口：ValidatorFactory。LocalValidatorFactoryBean是ValidatorFactory的一个实现类。<mvc:annotation-driven ></mvc:annotation-driven>会在springmvc容器中自动加载一个LocalValidatorFactoryBean类，因此可以直接实现数据校验。

就日常使用来说，比如支持@Valid等一系列校验注解。

#### 4.数据类型转换和数据格式化

< mvc:annotation-driven/>支持ConversionService，可以进行常见数据类型的转换和格式化。

ConversionService：定义了一个统一的API，用于在运行时执行类型转换逻辑。大多数ConversionService实现还实现ConverterRegistry，该注册器提供用于注册转换器的SPI。在内部，ConversionService实现委派其注册的转换器执行类型转换逻辑。
ConversionService会在应用程序启动时实例化，然后在多个线程之间共享。
在Spring应用程序中，通常会为每个Spring容器（或ApplicationContext）配置一个ConversionService实例。

FormattingConversionServiceFactoryBean：一个工厂，提供对FormattingConversionService的便捷访问，该服务配置有用于常见类型（例如数字和日期时间）的转换器和格式化程序。

①默认：
添加 < mvc:annotation-driven/>后，会默认创建一个ConversionService，即 FormattingConversionServiceFactoryBean。
使用FormattingConversionServiceFactoryBean可以让SpringMVC支持@NumberFormat和@DateTimeFormat等Spring内部自定义的转换器。

②：自定义：
默认的ConversionService可以在字符串，数字，枚举，集合，映射和其他常见类型之间进行转换。
如果要实现其他的类型转换，比如将字符串 “LiHua”-23-“男” 转换为Student实体类，可以自定义类型转换器。
要支持自己自定义的格式器和转换器（实现Converter，ConverterFactory或GenericConverter接口），只需自定义相应的类并加入IOC容器，然后通过设置converters属性将自定义的转换器注册到ConversionService即可。

XML配置文件：

```xml
   <mvc:annotation-driven conversion-service="conversionService"/>
   <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
        <property name="converters">
           <set>
              <ref bean="employeeConverter"/>
          </set>
       </property>
  </bean>
```

#### 5.支持使用@RequestBody、@ResponseBody

#### 6.支持静态资源文件加载和请求映射同时使用
在配置完静态资源访问后，如果没有配置< mvc:annotation-driven/>，springmvc将只能访问静态资源，而无法进行请求映射。
因此，有静态资源文件需要加载的时候，一定要配置< mvc:annotation-driven/>。

< mvc:annotation-driven/>允许将DispatcherServlet映射到“ /”（从而覆盖了容器默认Servlet的映射），同时仍允许容器默认Servlet处理静态资源请求。 它使用URL映射“ / **”配置DefaultServletHttpRequestHandler，并且相对于其他URL映射具有最低优先级。

关于静态资源访问的配置：
在springmvc中，直接访问静态资源会404，因为之前配置的拦截器会将所有的请求通过/拦截，交给mvc的入口DispatcherServlet去匹配@RequestMapping/path，访问不到就报错了。

解决：如果是需要mvc处理的，则交给@RequestMapping；如果不需要mvc处理，则使用服务器（Tomcat）默认的servlet处理：对应的请求交给servlet处理，没有对应的servlet则直接访问。默认的servlet在Tomcat配置文件\conf/web.xml中。

加载静态资源的三种方案：
①使用< mvc:default-servlet-handler/>。
②配置/XX /**将静态资源文件映射到 ResourceHttpRequestHandler 进行处理。

```xml
 <mvc:resources mapping="/js/**" location="/js/"></mvc:resources>
 <mvc:resources mapping="/css/**" location="/css/"></mvc:resources>
```

③激活Tomcat的defaultServlet来处理静态文件。

```xml
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.jpg</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
</servlet-mapping>
```

注意：如果不使用< mvc:resources/>注册HandlerMapping，而要设置自己的自定义HandlerMapping实例，请确保将其order属性设置为小于DefaultServletHttpRequestHandler的Integer.MAX_VALUE的值。
因为spring 会先执行 order 值比较小的，默认的应该servlet在最后执行，以便于处理不可能进行请求映射的静态资源访问。

**补充理解：**

DefaultAnnotationHandlerMapping 的 order 属性值是：0。
<mvc:resources/ >自动注册的 SimpleUrlHandlerMapping 的 order 属性值是： 2147483646。
< mvc:default-servlet-handler/>自动注册的 SimpleUrlHandlerMapping 的 order 属性值是：2147483647。
因此映射的顺序是：注解映射——<mvc:resources/ >映射的静态资源——< mvc:default-servlet-handler/> 兜底。

#### 7.其他功能
启用矩阵变量：在MVC命名空间中，<mvc：annotation-driven>元素具有应设置为true的enable-matrix-variables属性。 默认情况下，它设置为false。

配置异步请求处理：MVC Java配置和MVC名称空间提供用于配置异步请求处理的选项。 WebMvcConfigurer具有方法configureAsyncSupport，而<mvc：annotation-driven>具有子元素。

创建ContentNegotiationManager：在MVC命名空间中，<mvc：annotation-driven>元素具有content-negotiation-manager属性，该属性期望可以使用ContentNegotiationManagerFactoryBean创建ContentNegotiationManager。

数据绑定支持。



## < mvc:annotation-driven /> 和< context:annotation-config/>的关系：
< mvc:annotation-driven />：虽然有这么多功能，但主要还是为了Spring MVC来用的，提供Controller请求转发，json自动转换等功能。

< context:annotation-config/>：向 Spring 容器注册 4 个BeanPostProcessor。注册这4个 BeanPostProcessor的作用，就是为了系统能够识别相应的注解。常见的如：@ Resource 、@Required、@Autowired等。
不过，其实包扫描配置<context:component-scan base-package=”XX.XX”/> 也提供上述功能，因此当启动用了包扫描就不必再配置< context:annotation-config/>了。