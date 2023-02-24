

## Spring Framework学习路线

```txt
第一部分：核心容器
	核心概念（IoC/DI）
	容器基本操作
第二部分：整合
	整合数据层MyBatis
第三部分：AOP
	核心概念
	AOP基础操作
	AOP实用开发
第四部分：事务
	事务实用开发
```

## 一、核心容器

核心概念：

IoC：Inversion of Control控制反转，使用对象时，由制动new产生的对象转换为**外部**提供。此过程中对象创建控制权由程序转移到外部，是一中思想。

ioc容器：spring是实现了IoC思想，提供了一个容器，称IoC容器。

DI：依赖注入，在容器中建立bean之间的依赖关系。

### Spring中bean的实例化方式：四种

```xml

    <!--第一种：通过默认空参构造反射创建-->
    <bean id="daoImp" class="com.acai.factory.DaoFactoryBean"/>

    <!--第二种：通过静态工厂创建-->
    <bean id="daoImp2" class="com.acai.factory.DaoFactory" factory-method="getDaoBean"/>

    <!--第三种：通过实例工厂创建-->
    <bean id="daoFactory" class="com.acai.factory.DaoFactory2"/>
    <bean id="daoImp3" factory-bean="daoFactory" factory-method="getDao"/>

    <!--第四种：通过实例工厂创建，优化-->
    <!--实现FactoryBean接口，实现getObject()和getObjectType()方法-->
    <bean id="daoImp4" class="com.acai.factory.DaoFactoryBean"/>
```



### bean的生命周期：两种实现

```xml
     <!--第一种：bean的生命周期，配置实现-->
    <bean id="daoImp5" class="com.acai.dao.DaoImp2" init-method="init" destroy-method="close"/>
	<!--第二种：bean生命周期，实现InitializingBean,和DisposableBean接口-->

    <!--销毁对象-->
    <!--ctx.close() 手工关闭容器-->
    <!--设置关闭钩子,关闭jvm虚拟机之前，关闭容器-->
    <!--ctx.registerShutdownHook();-->
```



- bean在初始化阶段：

  初始化容器：

1. 创建对象（内存分配）
2. 执行构造方法
3. 执行实行注入（set操作）
4. 执行bean初始化方法

使用bean：

1. 执行业务操作

关闭/销毁容器

1. 执行bean销毁

### 依赖注入方式

- 普通方法（set方法）
- 构造方法

依赖注入分类：

- 引用类型
- 简单类型

依赖注入方式：

- setter注入

  1. 简单类型

     ```xml
      <!--依赖注入：setter注入简单类型-->
     <!--类中事先设置setter方法-->
         <bean id="user" class="com.acai.pojo.User">
             <property name="name" value="acai"/>
             <property name="age" value="18"/>
         </bean>
     ```

  2. 引用类型

     ```xml
     <!--依赖注入：setter注入引用类型-->
         <bean id="servicesImp" class="com.acai.services.ServicesImp">
             <property name="dao" ref="daoImp"/>
         </bean>
     ```

- 构造器注入

1. 简答类型

   ```xml
    <!--构造器注入：引用类型-->
       <bean id="services" class="com.acai.services.ServicesImp">
           <constructor-arg name="name" value="acai"/>
           <constructor-arg name="age" value="18"/>
       </bean>
   
   <!--优化-->
    <bean id="services" class="com.acai.services.ServicesImp">
           <constructor-arg  index="0" value="acai"/>
           <constructor-arg  index="1" value="18"/>
       </bean>
   
   ```

2. 引用类型

   ```xml
      <!--构造器注入：引用类型-->
   	<!--事先准备带参构造-->
       <bean id="servicesImp" class="com.acai.services.ServicesImp">
           <constructor-arg name="dao" ref="daoImp"/>
           <constructor-arg name="user" ref="user"/>
       </bean>
   
   <!--优化-->
    <!--构造器注入：引用类型-->
       <bean id="services" class="com.acai.services.ServicesImp">
           <constructor-arg index="0" value="acai"/>
           <constructor-arg index="1" value="18"/>
       </bean>
   ```

   #### 依赖方式的选择：

1. 强制依赖使用构造器注入，使用setter注入有概率导致注入null对象出现
2. 可选依赖使用setter注入进行，灵活
3. Spring框架倡导使用构造器注入，严谨
4. 有必要时同时使用
5. 根据实际项目
6. 自己开发模块推荐setter注入

###  依赖自动装配

概述：IoC容器根据bean所依赖的资源在容器中自动查找并注入到bean中的过程

自动装配的方式：

- 按类型（常用）

  ```xml
   <bean id="servicesImp" class="com.acai.services.ServicesImp" autowire="byType"/>
  ```

- 按名称

- 按构造方法

- 不启用自动装配

依赖自动装配

- 自动装配用于引用类型
- 按类型，相同类型的bean唯一。推荐使用
- 按名称，与变量名耦合，不推荐使用
- 自动装配优先级低于setter与构造器注入，同时出现，自动装配失效

### 集合注入

```xlm
数组 List Set Map Properties
```

### 案例：数据源对象管理

```xml

    <!--管理DruidDataSource-->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/spring_db"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <bean id="c3p0" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/spring_db"/>
        <property name="user" value="root"/>
        <property name="password" value="root"/>
        <property name="maxConnectionAge" value="100"/>
    </bean>
```

### 加载Properties文件

```xml
<!--1.开启context命名空间-->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-context.xsd

       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
">
```

```xml
<!--2.使用context命名空间加载Properties文件-->
<context:property-placeholder location="classpath*:jdbc.properties" system-properties-mode="NEVER"/>
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
```

### 容器

```
创建容器	获取bean	容器类层次结构	BeanFactory（所有容器类的顶层接口）
```

```java
//1.加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.在文件系统获中取配置文件
        ApplicationContext ctx2 = new FileSystemXmlApplicationContext("C:\\Users\\阿才\\Desktop\\SR\\代码\\spring\\src\\main\\resources\\applicationContext.xml");

        //3.获取bean方式一
        DataSource dataSource = (DataSource) ctx.getBean("c3p0");
        //4.获取bean方式二
        Dao dao = ctx.getBean("dao", Dao.class);
        //5..获取bean方式三
        Dao dao2 = ctx.getBean(Dao.class);
```

### 核心容器总结

- 容器相关

  BeanFactory是IoC容器的顶层接口，初始化BeanFactory对象时，加载bean延迟加载

  ApplicationContext接口是Spring容器的核心接口，初始化时bean立即加载

  ApplicationContext接口提供基础bean操作相关的方法，通过其他接口扩展功能

  ApplicationContext接口常用初始化类

  ​		ClassPathXmlApplicationContext

  ​		FileSystemXmlApplicationContext

- bean相关

- 依赖注入相关

## 二、注解开发

### 注解开发bean

```xml
给bean添加注解
//@Component("dao")
@Controller
@Service
@Repository("dao")

核心配置文件中扫描bean
  <context:component-scan base-package="com.acai"/>
```

### 纯注解开发

```java
Spring3.0开启了纯注解开发，使用java类代替配置文件
自定义一个配置类，给注解
@Configuration	//代替核心配置文件
@ComponentScan({"com.acai.service"，"com.acai.dao"})	//定义扫描器，该注解只能添加一次，多合数据可用数组

//1.加载类路径下的配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
```

### bean管理

#### 作用范围

```java
@Scope	//单例
@Scope("singleton")	//单例
@Scope("prototype")//非单例
```

#### 生命周期

```java
 @PostConstruct
    public void init() {
        System.out.println("DaoImp#init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DaoImp#destory()");
    }
```

### 自动装配--依赖注入

```java
//使用 @Autowired注解开始自动装配模式（按类型）
@Service
public class ServicesImp implements Services {
    @Autowired
    private Dao dao;
    
    @Override
    public void fun() {
        System.out.println("Services#fun()");
        dao.fun();
    }
}
```

注意：自动装配基于反射设计创建对象并暴力反射对应属性为私有属性初始化方法，因此无需提供setter方法

注意：自动装配建议使用无参构造创建对象（默认），如果不提供对应构造方法，请提供唯一的构造方法

```java
//使用@Qualifile注解开启指定名称装配bean
@Service
public class ServicesImp implements Services {

    @Autowired
    @Qualifier("dao")
    private Dao dao;

    @Override
    public void fun() {
        System.out.println("Services#fun()");
        dao.fun();
    }
}
```

注意：@Qualifile注解无法单独使用，必须配合@Autowired注解使用

```java
//使用@Value实现简单类型注入
public class DaoImp implements Dao {
    @Value("acai")
    private String name;

    @Override
    public void fun() {
        System.out.println("DaoImp#fun()" + name);
    }
}
```

加载外部配置文件

```java
@Configuration
@ComponentScan({"com.acai"})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {}
```

### 第三方bean管理

#### 第三方的bean管理

```java
public class JDBCConfig {
    @Bean
    public DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}


@Configuration
@ComponentScan({"com.acai"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCConfig.class)
public class SpringConfig {}
```

#### 第三方bean依赖注入

```java
//简单类型依赖注入   成员变量
public class JDBCConfig {

    @Value("com.mysql.jdbc.Driver")
    private String DriverClassNam;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();    dataSource.setDriverClassName(DriverClassNam);
        return dataSource;
    }
}

//引用类型依赖注入  方法形参
public class JDBCConfig {

    @Value("com.mysql.jdbc.Driver")
    private String DriverClassNam;

    @Bean
    public DataSource dataSource(Dao dao) {
        System.out.println(dao);
        DruidDataSource dataSource = new DruidDataSource();
   dataSource.setDriverClassName(DriverClassNam);
        return dataSource;
    }
}
```

### 注解配置与XML配置比较

![S1676350991726](img/1676350991726.png)

## 三、Spring整合MyBatis

```xml
<!--导入Maven依赖-->
  <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.0.2.RELEASE</version>
    </dependency>
```

jdbc.properties

```properties
url=jdbc:mysql://localhost:3306/acai_db?serverTimezone=UTC
user=root
password=123456
driver=com.mysql.cj.jdbc.Driver
```

JDBCConfig.java

```java
package com.mybatis.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
public class JDBCConfig {
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
```

MybatisConfig.java

```java
package com.mybatis.config;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.mybatis.pojo.User");
        ssfb.setDataSource(dataSource);
        return ssfb;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.mybatis.dao");
        return msc;
    }
}
```

SpringConfig.java

```java
package com.mybatis.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan("com.mybatis")
@PropertySource("jdbc.properties")
@Import({JDBCConfig.class,MybatisConfig.class})
public class SpringConfig {
}
```

APP.java

```java
package com.mybatis;
import com.mybatis.config.SpringConfig;
import com.mybatis.pojo.User;
import com.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
public class APP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = context.getBean(UserService.class);
        List<User> list = service.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
```







## 四、Spring整合Junit

```xml
<!--导入Maven依赖-->
   <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.0.2.RELEASE</version>
        </dependency>
```

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServicesTest {

    @Autowired
    private Services services;

    @Test
    public void servicesTest() {
        services.fun();
    }
}
```

