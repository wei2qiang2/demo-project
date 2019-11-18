package com.demo.mysql;

import com.demo.mysql.consts.Const;
import com.demo.mysql.entity.FamilyNames;
import com.demo.mysql.entity.TestInfo;
import com.demo.mysql.mapper.FamilyNamesMapper;
import com.demo.mysql.service.IFamilyNamesService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


public class GenerateRealNameTest extends TestParent{
    @Autowired
    private FamilyNamesMapper familyNamesMapper;

    @Autowired
    private IFamilyNamesService familyNamesService;


    @Test
    public void test(){
        System.err.println(familyNamesMapper);

        this.testInfo = TestInfo.getInstance("ces", "ads", 123L, new Date(), new Date());
    }

    /**
     * 一个字段 逐条插入
     */
    @Test
    public void testInserEveryOne(){
        String [] namesArr = Const.FAMILY_NAMES.split(" ");
        Set<String> set = new HashSet(Arrays.asList(namesArr));
        List<FamilyNames> nameList = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if (StringUtils.isNotBlank(str)){
                FamilyNames familyNames = new FamilyNames();
                familyNames.setFisrtName(str);
                nameList.add(familyNames);
            }
        }
        TestInfo testInfo = new TestInfo();
        Date start =  new Date();
        testInfo.setStartTime(start);
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i).getFisrtName());
            familyNamesMapper.insert(nameList.get(i));
        }
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("只有一个字段的姓氏表,且姓氏字段无唯一索引，逐条插入","插入", end.getTime() - start.getTime(), start, end);
    }

    @Test
    public void testInsrtBatch(){
        String [] namesArr = Const.FAMILY_NAMES.split(" ");
        Set<String> set = new HashSet(Arrays.asList(namesArr));
        List<FamilyNames> nameList = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if (StringUtils.isNotBlank(str)){
                FamilyNames familyNames = new FamilyNames();
                familyNames.setFisrtName(str);
                nameList.add(familyNames);
            }
        }
        Date start =  new Date();
        familyNamesService.insertBatch(nameList);
        TestInfo testInfo = new TestInfo();
        testInfo.setStartTime(start);
        Date end = new Date();
        this.testInfo = TestInfo.getInstance("只有一个字段的姓氏表,且姓氏字段有唯一索引，批量插入","插入", end.getTime() - start.getTime(), start, end);
    }
}
