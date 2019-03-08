package com.frank.boot.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.domain.system.SysMenus;
import com.frank.boot.domain.user.SysPermission;
import com.frank.boot.dao.system.SysMenusMapper;
import com.frank.boot.dao.user.SysPermissionMapper;
import com.frank.boot.service.system.SysMenusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.frank.boot.service.user.SysPermissionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-25
 */
@Service
public class SysMenusServiceImpl extends ServiceImpl<SysMenusMapper, SysMenus> implements SysMenusService {
    @Autowired
    SysPermissionService sysPermissionService;
	@Override
    public List<SysMenus> getMenusByFileter(int pid,String menuFilter) {
        return this.getMenusByPid(0,menuFilter);
    }

    private List<SysMenus> getMenusByPid(int pId,String menuFilter){
        QueryWrapper<SysMenus> query = new QueryWrapper<>();
        query.eq("pid",pId);
        if (!StringUtils.isEmpty(menuFilter)) {
            query.inSql("id",menuFilter);
        }

        List<SysMenus> menusList = this.list(query);
        if(menusList.size() > 0){
            for(SysMenus menu : menusList) {
                menu.setChildren(this.getMenusByPid(menu.getId(),menuFilter));
                if(!StringUtils.isEmpty(menu.getPermissions())){
                	Collection<String> col = new ArrayList<String>();
//                	String [] pers = menu.getPermissions().split(",");
//                	for (String per : pers) {
//						col.add(per);
//					}
                	menu.setPermissionsArray(
                        sysPermissionService.list(new QueryWrapper<SysPermission>().in("pkey", menu.getPermissions().split(",")))
                	);
                }
            }
        }
        return menusList;
    }
}

