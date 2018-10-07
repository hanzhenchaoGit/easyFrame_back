package com.frank.boot.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.domain.system.SysMenus;
import com.frank.boot.domain.user.SysPermission;
import com.frank.boot.dao.system.SysMenusMapper;
import com.frank.boot.dao.user.SysPermissionMapper;
import com.frank.boot.service.system.SysMenusService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

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
    SysPermissionMapper sysPermissionMapper;
	@Override
    public List<SysMenus> getMenusByFileter(int pid,String menuFilter) {
        return this.getMenusByPid(0,menuFilter);
    }

    private List<SysMenus> getMenusByPid(int pId,String menuFilter){
        EntityWrapper<SysMenus> query = new EntityWrapper<>();
        query.eq("pid",pId);
        query.in("id",menuFilter);
        List<SysMenus> menusList = this.selectList(query);
        if(menusList.size() > 0){
            for(SysMenus menu : menusList) {
                menu.setChildren(this.getMenusByPid(menu.getId(),menuFilter));
                if(!StringUtils.isEmpty(menu.getPermissions())){
                	Collection<String> col = new ArrayList<String>();
                	String [] pers = menu.getPermissions().split(",");
                	for (String per : pers) {
						col.add(per);
					}
                	menu.setPermissionsArray(
                		sysPermissionMapper.selectList(new EntityWrapper<SysPermission>().in("pkey", col))
                	);
                }
            }
        }
        return menusList;
    }
}

