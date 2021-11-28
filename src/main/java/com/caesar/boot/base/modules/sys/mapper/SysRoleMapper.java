package com.caesar.boot.base.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caesar.boot.base.modules.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author caesar
 * @since 2021-11-21
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 获取用户所有角色
     */
    List<SysRole> getRoleList(@Param("adminId") Long adminId);

}
