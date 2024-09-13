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

### 添加Log4j2依赖

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





### 增加配置文件log4j2.xml

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

    <bean id="accountManage" class="com.dingli.jdbc.service.impl.AccountManageImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate" />
    </bean>
```

### 代码类

`IAccountManage接口`

```java
public interface IAccountManage {

    // 插入账户记录
    public void addAccount(Account account);

    // 更新账户记录
    public void updateAccount(Account account);

    // 查询单个账户记录
    public void queryAccountById(Integer id);

    // 查询所有账户记录
    public void queryAllAccount();

    // 删除指定账户记录
    public void deleteAccount(Integer id);
}

```

`AccountManageImpl实现类`

```java
public class AccountManageImpl implements IAccountManage {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAccount(Account account) {
        //定义SQL插入语句，实现插入一条账户记录
        String sql = "insert into accounts(id,userName,balance) value(?,?,?)";
        //定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                account.getId(),
                account.getUserName(),
                account.getBalance()
        };
        //执行SQL插入语句，返回执行添加操作的记录条数
        int num = jdbcTemplate.update(sql, obj);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条账户记录");
            System.out.println(account);
        }
        else
            System.out.println("执行插入账户记录失败");

    }

    @Override
    public void updateAccount(Account account) {
        //定义SQL更新语句，实现根据账户id更新余额
        String sql = "update accounts set balance=? where id = ?";
        //定义数组来存放SQL语句中的参数
        Object[] params = new Object[] {account.getBalance(), account.getId()};
        //执行SQL更新语句，返回执行更新操作的记录条数
        int num = jdbcTemplate.update(sql, params);
        if (num > 0) {
            System.out.println("成功更新了" + num + "条账户记录");
        }
        else
            System.out.println("执行更新账户记录失败");

    }

    @Override
    public void queryAccountById(Integer id) {
        //定义SQL查询语句，实现根据账户id查询账户记录
        String sql = "select * from accounts where id = ?";
        //创建一个BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper;
        rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行SQL查询语句，并通过rowMapper返回Account类对象
        Account account = jdbcTemplate.queryForObject(sql, rowMapper, id);
        System.out.println("成功查询了1个账户记录");
        System.out.println(account);

    }

    @Override
    public void queryAllAccount() {
        //定义SQL查询语句，实现查询所有的账户记录
        String sql = "select * from accounts";
        //创建一个BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper;
        rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行SQL查询语句，并通过rowMapper返回存放Account类对象的List集合
        List<Account> accounts = jdbcTemplate.query(sql, rowMapper);
        System.out.println("成功查询了所有的账户记录");
        for (Account account:accounts) {		//循环输出每个账户记录
            System.out.println(account);
        }

    }

    @Override
    public void deleteAccount(Integer id) {
        //定义SQL删除语句，实现根据id删除账户记录
        String sql = "delete from accounts where id = ? ";
        //执行SQL删除语句，返回执行删除操作的记录条数
        int num = jdbcTemplate.update(sql, id);
        if (num > 0)
            System.out.println("成功删除了" + num + "条账户记录");
        else
            System.out.println("执行删除账户记录失败");

    }
}
```

`JdbcTemplateTest.class`

```java
public class JdbcTemplateTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "create table if not exists accounts (id int, userName varchar(50), balance double)";
        jdbcTemplate.execute(sql);
        System.out.println("数据库accounts创建成功");
        IAccountManage accountManage = context.getBean("accountManage", IAccountManage.class);
        Account account = new Account();
        account.setId(1);
        account.setUserName("张三");
        account.setBalance(2000.0);
        accountManage.addAccount(account);
    }
}
```



## 第六章 Spring MVC

## 依赖

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



## 第七章 数据绑定和请求响应

### 课后思考（作业）

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