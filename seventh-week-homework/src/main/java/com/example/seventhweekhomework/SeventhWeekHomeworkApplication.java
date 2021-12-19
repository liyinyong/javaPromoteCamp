package com.example.seventhweekhomework;

import com.example.seventhweekhomework.mapper.primary.UserInfoMapper;
import com.example.seventhweekhomework.mapper.slave.UserInfoSlaveMapper;
import com.example.seventhweekhomework.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "com.example.seventhweekhomework.mapper.primary")
public class SeventhWeekHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SeventhWeekHomeworkApplication.class, args);
    }


    @Resource
    private UserInfoMapper userInfoMapper;

    //    @Resource
//    private UserInfoSlaveMapper userInfoSlaveMapper;
    @Override
    public void run(String... args) throws Exception {
        log.info("主库：{}", userInfoMapper.selectByPrimaryKey(1L));
        //log.info("从库：{}", userInfoSlaveMapper.selectByPrimaryKey(2L));//this.testInsertData();
        this.testBatchInsertData();
    }

    /*
    * 一条一条插
    * */
    private void testInsertData() {
        UserInfo userInfo = new UserInfo();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Date now = new Date();
        for (int i = 0; i < 1000000; i++) {
            userInfo.setUserName("单条插入测试_" + i);
            userInfo.setPhone("" + i);
            userInfo.setNote("" + i);
            userInfo.setGmtCreate(now);
            userInfo.setGmtModified(now);
            userInfoMapper.insert(userInfo);
        }
        stopWatch.stop();
        log.info("时间：{}", stopWatch.getTotalTimeMillis());
    }

    /*
     * 批量插
     * */
    private void testBatchInsertData() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("批量100000插入测试_" + i);
            userInfo.setPhone("" + i);
            userInfo.setNote("" + i);
            userInfoList.add(userInfo);
            if(userInfoList.size() == 100000) {
                userInfoMapper.insertbatch(userInfoList);
                userInfoList.clear();
            }
        }
        stopWatch.stop();
        log.info("时间：{}", stopWatch.getTotalTimeMillis());
    }
}
