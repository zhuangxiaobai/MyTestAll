package com.zc.spring_security_demo.serviceImpl;

import com.zc.spring_security_demo.entity.EUser;
import com.zc.spring_security_demo.mapper.EUserMapper;
import com.zc.spring_security_demo.service.EUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zc
 * @since 2021-01-19
 */
@Service
public class EUserServiceImpl extends ServiceImpl<EUserMapper, EUser> implements EUserService {

}
