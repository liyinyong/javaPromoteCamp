package com.example.fiveweekhomework;

import com.example.fiveweekhomework.bean.Student;
import com.example.fiveweekhomework.mapper.StudentDao;
import com.example.fiveweekhomework.service.StudentJDBCService;
import com.example.fiveweekhomework.util.ApplicationUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.fiveweekhomework.mapper")
public class FiveWeekHomeworkApplication implements CommandLineRunner {
    @Autowired
    private GenericApplicationContext genericApplicationContext;
    @Resource
    private StudentDao studentDao;
    @Resource
    private StudentJDBCService studentJDBCService;

    public static void main(String[] args) {
        SpringApplication.run(FiveWeekHomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("local-bean.xml");
        Student xmlStudent = applicationContext.getBean("xmlStudent", Student.class);
        System.out.println("xml:" + xmlStudent);

        Student annotationStudent = ApplicationUtil.getBean("annotationStudent", Student.class);
        System.out.println("annotation:" + annotationStudent);

        genericApplicationContext.registerBean("manualStudent", Student.class, 3, "manualStudent");
        System.out.println("manual:" + ApplicationUtil.getBean("manualStudent", Student.class));

        System.out.println("查询结果：" + studentDao.selectByPrimaryKey(1L));

        System.out.println("autoConfig:" +genericApplicationContext.getBean("autoConfigurationStudent"));
        studentJDBCService.insert(new Student(null, "李四"));
        studentJDBCService.update(new Student(3, "李四1"));
        //studentJDBCService.delete(2);
        System.out.println(studentJDBCService.query(2));
    }
}
