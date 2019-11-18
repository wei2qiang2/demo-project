package com.demo.mysql.service.impl;

import com.demo.mysql.entity.SysEmployee;
import com.demo.mysql.mapper.SysEmployeeMapper;
import com.demo.mysql.service.ISysEmployeeService;
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
public class SysEmployeeServiceImpl extends ServiceImpl<SysEmployeeMapper, SysEmployee> implements ISysEmployeeService {

}
