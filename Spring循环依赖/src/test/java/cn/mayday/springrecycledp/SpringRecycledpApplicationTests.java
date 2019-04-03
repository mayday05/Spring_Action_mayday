package cn.mayday.springrecycledp;

import cn.mayday.springrecycledp.demo1.StudentA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRecycledpApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext1.xml");
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext2.xml");
        System.out.println(context.getBean("a", StudentA.class));

    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext3.xml");
        System.out.println(context.getBean("a", StudentA.class));
    }

}
