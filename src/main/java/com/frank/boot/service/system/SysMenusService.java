package com.frank.boot.service.system;

import com.frank.boot.domain.system.SysMenus;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author frank
 * @since 2018-06-25
 */
public interface SysMenusService extends IService<SysMenus> {
//    void saveRoleMenu
    List<SysMenus> getMenusByFileter(int pid,String menuFilter);
}
