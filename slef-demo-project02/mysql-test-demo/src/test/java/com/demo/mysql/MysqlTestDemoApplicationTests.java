package com.demo.mysql;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.mysql.entity.SysEmployee;
import com.demo.mysql.mapper.FamilyNamesMapper;
import com.demo.mysql.mapper.SysEmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTestDemoApplicationTests {
    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

    @Autowired
    private FamilyNamesMapper familyNamesMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertSysEmployee(){
        SysEmployee sysEmployee = new SysEmployee();
        sysEmployee.setRealName("张三");
        sysEmployee.setAddTime(new Date());
        sysEmployee.setAccount("zhangsan");
        sysEmployee.setAddEmployee(1L);
        sysEmployee.setCardId("001");
        sysEmployee.setCode("ZS");
        sysEmployee.setDirectDeptId(1L);
        sysEmployee.setEmail("1@qq.com");
        sysEmployee.setLoginCount(0);
        sysEmployee.setTenantId("WQ");
        sysEmployee.setTel("1234");
        sysEmployee.setPassword("ssss");
        sysEmployee.setSex(1);
        sysEmployee.setMajorDeptId(1L);
        sysEmployee.setSalt("zs");
        sysEmployee.setPhoneNum("12121");
        sysEmployee.setUnitId(1L);
        sysEmployeeMapper.insert(sysEmployee);
    }

    @Test
    public void testSelectSysEmployeeList(){
        EntityWrapper<SysEmployee> wrapper = new EntityWrapper<>();
        List<SysEmployee> sysEmployees = sysEmployeeMapper.selectList(wrapper);
    }

    @Test
    public void test(){
        System.err.println(familyNamesMapper);
    }
}
