package cn.mayday.springtxdemo.transaction1;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/3/31 12:08
 * @version: 1.0
 */
@RestController
public class TxController {

    @Autowired
    private TxService serviceImpl; // 注意注入的类必须为接口，因为配置事务后实际加载的类是动态代理类，而不是ServiceImpl类

    @GetMapping("/testTx")
    public void testTx() {
        //是否是JDK动态代理
        System.out.println("isJdkDynamicProxy => " + AopUtils.isJdkDynamicProxy(serviceImpl));
        //是否是CGLIB代理
        System.out.println("isCglibProxy => " + AopUtils.isCglibProxy(serviceImpl));

        System.out.println("----------------------------------------------------");


        //代理类的类型
        System.out.println("proxyClass => " + serviceImpl.getClass());
        //代理类的父类的类型
        System.out.println("parentClass => " + serviceImpl.getClass().getSuperclass());
        //代理类的父类实现的接口
        System.out.println("parentClass's interfaces => " + Arrays.asList(serviceImpl.getClass().getSuperclass().getInterfaces()));
        //代理类实现的接口
        System.out.println("proxyClass's interfaces => ");
        List list1 = Arrays.asList(serviceImpl.getClass().getInterfaces());
        list1.forEach(list ->
                System.out.println(list)
        );


        System.out.println("----------------------------------------------------");

        //代理对象
        System.out.println("proxy => " + serviceImpl);
        //目标对象
        System.out.println("target => " + AopProxyUtils.getSingletonTarget(serviceImpl));
        //代理对象和目标对象是不是同一个
        System.out.println("proxy == target => " + (serviceImpl == AopProxyUtils.getSingletonTarget(serviceImpl)));

        System.out.println("----------------------------------------------------");

        //目标类的类型
        System.out.println("targetClass => " + AopProxyUtils.getSingletonTarget(serviceImpl).getClass());
        //目标类实现的接口
        System.out.println("targetClass's interfaces => " + Arrays.asList(AopProxyUtils.getSingletonTarget(serviceImpl).getClass().getInterfaces()));

        System.out.println("----------------------------------------------------");

        //自己模拟的动态代理的测试
        TxService target = new ServiceImpl();
        ProxyByJdkDynamic proxy = new ProxyByJdkDynamic(target);
        proxy.doNeedTx();
        System.out.println("-------");
        proxy.doNotneedTx();
        System.out.println("-------");
    }
}
