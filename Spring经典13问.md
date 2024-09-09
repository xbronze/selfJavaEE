

[TOC]

## 1、什么是 Spring IoC ？

IoC 即控制反转，简单来说就是把原来代码里需要实现的对象创建、依赖反转给容器来帮忙实现，Spring 中管理对象及其依赖关系都是通过 Spring 的 IoC 容器实现的。
IoC 的实现方式有依赖注入和依赖查找，由于依赖查找使用的很少，因此 IoC 也叫做依赖注入。
我们之前在创建一个对象的时候都是直接 new 一个对象实例，而有了 IoC ，对象实例的创建都交给容器去实现即可。

## 2、Spring IOC 容器的构建流程（初始化过程）

我们以 XML 方式的容器初始化为例：
通过 `ClassPathXmlApplicationContext`，去创建 ApplicationContext 容器对象：

```xml
ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
```

`ClassPathXmlApplicationContext`创建容器对象时，构造方法做了如下两件事：

① 调用父容器的构造方法为容器先设置好 Bean 资源加载器。
② 调用父类的 setConfigLocations() 方法设置 Bean 配置信息的定位路径
③ 调用父类 AbstractApplicationContext 的 refresh() 方法启动整个 IoC 容器对 Bean 的载入，在创建 IoC 容器前如果已有容器存在，需要把已有的容器销毁，保证在 refresh() 方法后使用的是新创建的 IoC 容器。
容器创建完成后，通过 loadBeanDefinitions() 方法加载 Bean 配置资源，该方法在加载资源时，首先解析配置文件路径，读取配置文件的内容，然后通过 XML 解析器将 Bean 的配置信息转换成文档对象，之后按照 Spring Bean 的定义规则将文档对象解析为 BeanDefinition 对象。
接下来，将解析得到的 BeanDefinition 对象存入本地缓存（一个 HashMap 集合，key 是字符串，值是 BeanDefinition）中。
最后，实例化所有的 Bean 实例（非懒加载）：包括实例的创建，实例的属性填充，实例的初始化。

## 3、依赖注入的过程（Bean 的加载流程）？

先来看下面几行代码：

```java
public class BeanFactoryTest {
    public static void main(String[] args) {
        // 加载与解析XML配置文件，获得BeanFactory：
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-bf.xml"));
        // 从BeanFactory中加载Bean对象
        Object a = beanFactory.getBean("componentA");
        Object b = beanFactory.getBean("componentB");
        System.out.println(a);// com.myspring.test.xmltest.ComponentA@1c93084c
        System.out.println(b);// com.myspring.test.xmltest.ComponentB@6ef888f6
    }
}
```

首先通过 BeanFactory/ApplicationContext 调用getBean() 方法，来获取 Bean 实例，该方法中，真正获取 Bean 实例的是其内层方法 doGetBean() 方法（真正实现从 IOC 容器获取 Bean ，也是触发依赖注入的地方）。
在 doGetBean() 方法中，主要做了以下几件事：
① beanName 的转换方法 transformedBeanName(name)，该方法的作用是，根据传入的 name 参数，获取真正的 Bean 对应的 beanName。该方法的 name 参数，有可能是一个别名（alias 属性设置的别名），也有可能是一个&开头的 name (工厂 Bean 对象)。
② 尝试从缓存中加载 Bean 的单实例，根据上面transformedBeanName方法转换 name 后得到的真实 beanName，getSingleton(beanName)方法直接尝试从缓存中获取 Bean 的共享单实例，这时候获取的是初始状态，尚未实例化。（从缓存中加载的流程就是，根据 beanName 依次从一级缓存、二级缓存、三级缓存中尝试获取，通过三级缓存机制也可以有效避免循环依赖）
③ Bean 的实例化，getSingleton(beanName)方法执行后，从缓存中得到了 Bean 的原始状态，接下来需要对该 Bean 进行实例化。
④ Bean 的初始化：寻找依赖(循环依赖检查、依赖注入)，因为 Bean 的初始化过程中很可能会用到某些属性，而某些属性很可能是动态配置的，并且配置的成依赖于其他的 Bean，那么此时应该先加载依赖的 Bean。所以在流程中，Spring初始化一个 Bean，会先初始化其依赖的所有的其他 Bean。
⑤ 根据不同的 scope 作用域创建 Bean，调用doCreateBean() 方法创建 Bean。
⑥ 类型转换，根据 scope 创建完 Bean 成功后，一般可以直接返回即可。但当传入 doGetBean 方法中的 requireType 参数不为空时，意味着我们对最后返回的 Bean 有着类型上的要求。Spring 通过 类型转换器 将第 ⑤ 步创建完成的 Bean 转换为 requireType 指定的类型。

## 4、Bean 的作用范围？

通过 scope 属性指定 Bean 的作用范围，包括：

① singleton：单例模式，是默认作用域，不管收到多少 Bean 请求每个容器中只有一个唯一的 Bean 实例。
② prototype：原型模式，和 singleton 相反，每次 Bean 请求都会创建一个新的实例。
③ request：每次 HTTP 请求都会创建一个新的 Bean 并把它放到 request 域中，在请求完成后 Bean 会失效并被垃圾收集器回收。
④ session：和 request 类似，确保每个 session 中有一个 Bean 实例，session 过期后 bean 会随之失效。
⑤ global session：当应用部署在 Portlet 容器时，如果想让所有 Portlet 共用全局存储变量，那么该变量需要存储在 global session 中。

## 5、说一说Spring Bean 的生命周期？

Spring Bean 生命周期简单概括为 5 个阶段：

Bean 的实例化阶段：创建一个 Bean 对象。
Bean 实例的属性填充阶段：为 Bean 实例的属性赋值。
Bean 实例的初始化阶段：对 Bean 实例进行初始化。
Bean 实例的正常使用阶段。
Bean 实例的销毁阶段：容器关闭后，将 Bean 实例销毁。

## 6、FactoryBean、BeanFactory、ApplicationContext 有什么区别？

BeanFactory：是一个 Bean 工厂，使用简单工厂模式，是 Spring IoC 容器顶级接口，是用于管理 Bean 的工厂，最核心的功能是通过 getBean() 方法加载 Bean 对象，通常我们不会直接使用该接口，而是使用其子接口 ApplicationContext。
FactoryBean：是一个工厂 Bean，使用了工厂方法模式，实现该接口的类可以自己定义要创建的 Bean 实例，只需要实现它的 getObject() 方法即可。
ApplicationConext：是 BeanFactory 的子接口，扩展了 BeanFactory 的功能（高级 IOC 容器）。



## 7、依赖注入的实现方法，以及相关注解？

构造方法注入、Setter 方法注入、接口注入 三种。

依赖注入的相关注解

@Autowired：自动按类型注入，如果有多个匹配则按照指定 Bean 的 id 查找，查找不到会报错。
@Qualifier：在自动按照类型注入的基础上再按照 Bean 的 id 注入，给变量注入时必须搭配@Autowired，给方法注入时可单独使用。
@Resource ：直接按照 Bean 的 id 注入，只能注入 Bean 类型。
@Value ：用于注入基本数据类型和 String 类型。

## 8、AOP 是什么？AOP有哪些应用场景？

AOP 概念： 即面向切面编程，使用动态代理技术，在不修改源码的基础上对目标方法进行增强。

Spring 中的 AOP 目前支持 JDK 动态代理和 Cglib 代理。如果被代理对象实现了接口，则使用 JDK 动态代理，否则使用 Cglib 代理。另外，也可以通过指定 proxyTargetClass=true 来实现强制走 Cglib 代理。

应用场景：

权限认证
日志打印
事务
…

## 9、AOP 的相关注解有哪些？

@Aspect：切面，声明被注解标注的类是一个切面 Bean。
@Pointcut：切入点，可以通过 @Pointcut("execution(* top.csp1999.service.impl.*.*(..))") 去指定要切入的目标对象，并对其符合表达式要求的方法进行增强。
@Before：前置通知，指在某个连接点之前执行的通知。
@After：后置通知，指某个连接点退出时执行的通知（不论正常返回还是异常退出）。
@AfterReturning：后置返回通知，指某连接点正常完成之后执行的通知，返回值可以在返回后通知方法里接收。
@AfterThrowing：后置异常通知，指方法抛出异常导致退出时执行的通知，和@AfterReturning只会有一个执行，异常使用 throwing 属性接收。
@Around：环绕通知，可以用来在调用一个具体方法前和调用后来完成一些具体的任务。

## 10、AOP 的相关术语有什么？

Aspect：切面，一个关注点的模块化，这个关注点可能会横切多个对象。
Joinpoint：连接点，程序执行过程中的某一行为，即业务层中的所有方法。。
Advice：通知，指切面对于某个连接点所产生的动作，包括前置通知、后置通知、返回后通知、异常通知和环绕通知。
Pointcut：切入点，指被拦截的连接点，切入点一定是连接点，但连接点不一定是切入点。
Proxy：代理，Spring AOP 中有 JDK 动态代理和 CGLib 代理，目标对象实现了接口时采用 JDK 动态代理，反之采用 CGLib 代理。
Target：代理的目标对象，指一个或多个切面所通知的对象。
Weaving ：织入，指把增强应用到目标对象来创建代理对象的过程。

## 11、JDK 动态代理和 CGLIB 代理有什么区别？

JDK 动态代理主要是针对类实现了某个接口，AOP 则会使用 JDK 动态代理。他基于反射的机制实现，生成一个实现同样接口的一个代理类，然后通过重写方法的方式，实现对代码的增强。
而如果某个类没有实现接口，AOP 则会使用 CGLIB 代理。他的底层原理是基于 ASM 第三方框架，通过修改字节码生成一个子类，然后重写父类的方法，实现对代码的增强。

## 12、Spring事务传播机制有哪些？
① REQUIRED：Spring 默认的事务传播级别，如果上下文中已经存在事务，那么就加入到事务中执行，如果当前上下文中不存在事务，则新建事务执行。
② REQUIRES_NEW：每次都会新建一个事务，如果上下文中有事务，则将上下文的事务挂起，当新建事务执行完成以后，上下文事务再恢复执行。
③ SUPPORTS：如果上下文存在事务，则加入到事务执行，如果没有事务，则使用非事务的方式执行。
④ MANDATORY：上下文中必须要存在事务，否则就会抛出异常。
⑤ NOT_SUPPORTED ：如果上下文中存在事务，则挂起事务，执行当前逻辑，结束后恢复上下文的事务。
⑥ NEVER：上下文中不能存在事务，否则就会抛出异常。
⑦ ESTED：嵌套事务。如果上下文中存在事务，则嵌套事务执行，如果不存在事务，则新建事务。

## 13、Spring 的事务隔离级别有哪些？
Spring 的事务隔离级别底层其实是基于数据库的，Spring 并没有自己的一套隔离级别。

DEFAULT：使用数据库的默认隔离级别。
READ_UNCOMMITTED：读未提交，最低的隔离级别，会读取到其他事务还未提交的内容，存在脏读。
READ_COMMITTED：读已提交，读取到的内容都是已经提交的，可以解决脏读，但是存在不可重复读。
REPEATABLE_READ：可重复读，在一个事务中多次读取时看到相同的内容，可以解决不可重复读，但是存在幻读。
SERIALIZABLE：串行化，最高的隔离级别，对于同一行记录，写会加写锁，读会加读锁。在这种情况下，只有读读能并发执行，其他并行的读写、写读、写写操作都是冲突的，需要串行执行。可以防止脏读、不可重复度、幻读，没有并发事务问题。



文章转载[https://www.jb51.net/article/214929.htm](https://www.jb51.net/article/214929.htm)

