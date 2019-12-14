package com.demo.mysql;

import com.demo.mysql.entity.SysEmployee;
import com.demo.mysql.entity.TestInfo;
import com.demo.mysql.enums.TimeEnum;
import com.demo.mysql.factory.BeanFactory;
import com.demo.mysql.service.ISysEmployeeService;
import com.demo.mysql.utils.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class SysEmployeeTest extends TestParent {

    @Autowired
    private ISysEmployeeService sysEmployeeService;

    @Test
    public void testInsertOne() {
        SysEmployee sysEmployee = new SysEmployee();

        sysEmployee.setAddTime(GenerateDate.generateDate(1, TimeEnum.DAY));
        sysEmployee.setAddEmployee(1L);
        sysEmployee.setIsDelete(1);

        String realName = GenerateRealName.generateName();
        sysEmployee.setRealName(realName);
        sysEmployee.setSalt(GenerateAccountAndPassword.generateSalt(realName));
        sysEmployee.setAccount(GenerateAccountAndPassword.generateAccount(realName));
        sysEmployee.setPassword(GenerateAccountAndPassword.generatePasssword(realName));
        sysEmployee.setSex(GenerateSex.generateSex());
        sysEmployee.setPhoneNum(GenerateMobilePhone.generatePhone());
        sysEmployee.setEmail(GenerateEmail.generateEmail());

        Date start = new Date();
        sysEmployeeService.insert(sysEmployee);
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("插入一个人员数据,无索引", "插入", end.getTime() - start.getTime(), start, end);

    }
    @Test
    public void testInsertOneAddStrage() {
        SysEmployee sysEmployee = new SysEmployee();

        sysEmployee.setAddTime(GenerateDate.generateDate(1, TimeEnum.DAY));
        sysEmployee.setAddEmployee(1L);
        sysEmployee.setIsDelete(1);

        String realName = GenerateRealName.generateName();
        sysEmployee.setRealName(realName);
        sysEmployee.setSalt(GenerateAccountAndPassword.generateSalt(realName));
        sysEmployee.setAccount(GenerateAccountAndPassword.generateAccount(realName));
        sysEmployee.setPassword(GenerateAccountAndPassword.generatePasssword(realName));
        sysEmployee.setSex(GenerateSex.generateSex());
        sysEmployee.setPhoneNum(GenerateMobilePhone.generatePhone());
        sysEmployee.setEmail(GenerateEmail.generateEmail());

        Date start = new Date();
        sysEmployeeService.insert(sysEmployee);
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("插入一个人员数据,无索引,增加自动填充策略", "插入", end.getTime() - start.getTime(), start, end);

    }

    /**
     * for循环插入十万条数据
     *
     * 到表里面有五万条数据的时候每秒钟智能插入100条
     */
    @Test
    public void testInsertShiWanForEach(){
        Random r = (Random) BeanFactory.getInstance(Random.class);
        List<SysEmployee> sysEmployeeList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            SysEmployee sysEmployee = new SysEmployee();

            sysEmployee.setAddTime(GenerateDate.generateDate(1, TimeEnum.DAY));
            sysEmployee.setAddEmployee(1L);
            sysEmployee.setIsDelete(1);

            String realName = GenerateRealName.generateName();
            sysEmployee.setRealName(realName);
            sysEmployee.setSalt(GenerateAccountAndPassword.generateSalt(realName));
            sysEmployee.setAccount(GenerateAccountAndPassword.generateAccount(realName));
            sysEmployee.setPassword(GenerateAccountAndPassword.generatePasssword(realName));
            sysEmployee.setSex(GenerateSex.generateSex());
            sysEmployee.setPhoneNum(GenerateMobilePhone.generatePhone());
            sysEmployee.setEmail(GenerateEmail.generateEmail());
            sysEmployee.setUnitId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployee.setMajorDeptId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployee.setDirectDeptId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployeeList.add(sysEmployee);
        }

        Date start = new Date();
        for (int i = 0; i < sysEmployeeList.size(); i++) {
            sysEmployeeService.insert(sysEmployeeList.get(i));
        }
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("for循环插入十万条人员数据,无索引,增加自动填充策略", "插入", end.getTime() - start.getTime(), start, end);
    }

    /**
     * 插入十万条数据批量插入
     *30000-40000
     * 当数据库达到四十万之后插入速度明显变慢
     *70000-84000
     * 当数据库达到80万条数据之后速度又满慢了一倍
     * 157000
     *
     * 在插入第90万数据的时候时间突然就变成了64003
     */
    @Test
    public void testInsertShiWanBatch(){
        Random r = (Random) BeanFactory.getInstance(Random.class);
        List<SysEmployee> sysEmployeeList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            SysEmployee sysEmployee = new SysEmployee();

            sysEmployee.setAddTime(GenerateDate.generateDate(1, TimeEnum.DAY));
            sysEmployee.setAddEmployee(1L);
            sysEmployee.setIsDelete(1);

            String realName = GenerateRealName.generateName();
            sysEmployee.setRealName(realName);
            sysEmployee.setSalt(GenerateAccountAndPassword.generateSalt(realName));
            sysEmployee.setAccount(GenerateAccountAndPassword.generateAccount(realName));
            sysEmployee.setPassword(GenerateAccountAndPassword.generatePasssword(realName));
            sysEmployee.setSex(GenerateSex.generateSex());
            sysEmployee.setPhoneNum(GenerateMobilePhone.generatePhone());
            sysEmployee.setEmail(GenerateEmail.generateEmail());
            sysEmployee.setUnitId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployee.setMajorDeptId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployee.setDirectDeptId(Long.valueOf(r.nextInt(1000) + ""));
            sysEmployeeList.add(sysEmployee);
        }

        Date start = new Date();
        sysEmployeeService.insertBatch(sysEmployeeList);
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("插入十万条人员数据,无索引,增加自动填充策略，在姓名上有一个普通索引，已有80万条数据", "插入", end.getTime() - start.getTime(), start, end);
    }

    public static void main(String[] args) {
        SysEmployee sysEmployee = new SysEmployee();

        sysEmployee.setAddTime(GenerateDate.generateDate(1, TimeEnum.DAY));
        sysEmployee.setAddEmployee(1L);
        sysEmployee.setIsDelete(1);

        String realName = GenerateRealName.generateName();
        sysEmployee.setRealName(realName);
        sysEmployee.setSalt(GenerateAccountAndPassword.generateSalt(realName));
        sysEmployee.setAccount(GenerateAccountAndPassword.generateAccount(realName));
        sysEmployee.setPassword(GenerateAccountAndPassword.generatePasssword(realName));
        sysEmployee.setSex(GenerateSex.generateSex());
        sysEmployee.setPhoneNum(GenerateMobilePhone.generatePhone());
        sysEmployee.setEmail(GenerateEmail.generateEmail());


        System.out.println(sysEmployee.toString());
    }
}
