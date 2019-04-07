package cn.mayday.springtxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@SpringBootApplication
public class SpringTxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTxDemoApplication.class, args);
    }



}
