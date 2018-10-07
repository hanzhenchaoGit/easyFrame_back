package com.frank.boot.service.system.impl;

import com.frank.boot.domain.system.SysCode;
import com.frank.boot.dao.system.SysCodeMapper;
import com.frank.boot.service.system.SysCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-09-15
 */
@Service
public class SysCodeServiceImpl extends ServiceImpl<SysCodeMapper, SysCode> implements SysCodeService {
}

