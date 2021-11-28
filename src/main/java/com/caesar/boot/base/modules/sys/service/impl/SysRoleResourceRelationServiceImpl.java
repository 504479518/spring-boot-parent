package com.caesar.boot.base.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caesar.boot.base.modules.sys.mapper.SysRoleResourceRelationMapper;
import com.caesar.boot.base.modules.sys.model.SysRoleResourceRelation;
import com.caesar.boot.base.modules.sys.service.SysRoleResourceRelationService;
import org.springframework.stereotype.Service;

/**
 * 角色资源关系管理Service实现类
 *
 * @author caesar
 * @date 2021/11/21
 */
@Service
public class SysRoleResourceRelationServiceImpl extends ServiceImpl<SysRoleResourceRelationMapper, SysRoleResourceRelation> implements SysRoleResourceRelationService {
}
