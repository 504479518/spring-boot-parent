package com.caesar.boot.base.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caesar.boot.base.modules.sys.mapper.SysAdminRoleRelationMapper;
import com.caesar.boot.base.modules.sys.model.SysAdminRoleRelation;
import com.caesar.boot.base.modules.sys.service.SysAdminRoleRelationService;
import org.springframework.stereotype.Service;

/**
 * 管理员角色关系管理Service实现类
 *
 * @author caesar
 * @date 2021/11/21
 */
@Service
public class SysAdminRoleRelationServiceImpl extends ServiceImpl<SysAdminRoleRelationMapper, SysAdminRoleRelation> implements SysAdminRoleRelationService {
}
