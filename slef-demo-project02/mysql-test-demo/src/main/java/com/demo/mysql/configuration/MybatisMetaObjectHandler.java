package com.demo.mysql.configuration;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.demo.mysql.consts.Const;
import com.demo.mysql.enums.TimeEnum;
import com.demo.mysql.factory.BeanFactory;
import com.demo.mysql.utils.GenerateDate;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class MybatisMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Random r = (Random) BeanFactory.getInstance(Random.class);
        this.setFieldValByName("addTime", GenerateDate.generateDate(10, TimeEnum.DAY), metaObject);
        this.setFieldValByName("addEmployee",Long.valueOf(r.nextInt(1000000) + ""), metaObject);
        this.setFieldValByName("isDelete", 1, metaObject);
        this.setFieldValByName("tenantId", Const.TENANT_ARRAY[r.nextInt(Const.TENANT_ARRAY.length)], metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Random r = (Random) BeanFactory.getInstance(Random.class);
        this.setFieldValByName("lastModifyTime", GenerateDate.generateDate(20, TimeEnum.DAY), metaObject);
        this.setFieldValByName("lastModifyEmployee",r.nextInt(100000), metaObject);
    }
}
