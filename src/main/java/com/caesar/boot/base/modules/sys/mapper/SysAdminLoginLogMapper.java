package com.caesar.boot.base.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caesar.boot.base.modules.sys.model.SysAdminLoginLog;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户登录日志表 Mapper 接口
 * </p>
 *
 * @author caesar
 * @since 2021-11-21
 */
@Repository
public interface SysAdminLoginLogMapper extends BaseMapper<SysAdminLoginLog> {

}
