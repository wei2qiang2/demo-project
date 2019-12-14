package com.demo.mysql.service.impl;

import com.demo.mysql.entity.TestInfo;
import com.demo.mysql.mapper.TestInfoMapper;
import com.demo.mysql.service.ITestInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wq
 * @since 2019-11-15
 */
@Service
public class TestInfoServiceImpl extends ServiceImpl<TestInfoMapper, TestInfo> implements ITestInfoService {

}
