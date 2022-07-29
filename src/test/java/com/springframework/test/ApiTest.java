package com.springframework.test;

import com.springframework.context.support.ClassPathXmlApplicationContext;
import com.springframework.test.bean.IUserService;
import com.springframework.test.bean.UserService;
import org.junit.Test;


public class ApiTest {

//    @Test
//    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
//        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        // 4. Bean实例化之后，修改 Bean 属性信息
//        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);
//
//        // 5. 获取Bean对象调用方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }
//
//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
