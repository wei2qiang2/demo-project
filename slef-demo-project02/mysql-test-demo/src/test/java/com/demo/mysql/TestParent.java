package com.demo.mysql;

import com.demo.mysql.entity.TestInfo;
import com.demo.mysql.mapper.TestInfoMapper;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestParent {

    @Autowired
    private TestInfoMapper testInfoMapper;

    public TestInfo testInfo;

    @After
    public void after() {
        testInfoMapper.insert(testInfo);
    }
}
