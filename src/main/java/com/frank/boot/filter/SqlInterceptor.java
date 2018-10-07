package com.frank.boot.filter;

import com.alibaba.fastjson.JSONObject;
import com.frank.boot.dao.user.SysGlobalsqllogMapper;
import com.frank.boot.domain.user.SysGlobalsqllog;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.utils.ReflectUtil;
import com.frank.boot.utils.SpringUtil;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Intercepts(value = {
        @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class })
})
@Component
public class SqlInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(SqlInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) {
    	Object result = null;
        
    	if(invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            //千万不能用下面注释的这个方法，会造成对象丢失，以致转换失败
            BoundSql boundSql = delegate.getBoundSql();
            String commondType = mappedStatement.getSqlCommandType().name();
            String name = "";
            if (commondType.startsWith("INSERT")) {
                name = "INSERT";
            } else if (commondType.startsWith("UPDATE")) {
                name = "UPDATE";
            } else if (commondType.startsWith("DELETE")) {
                name = "DELETE";
            } else if (commondType.startsWith("SELECT")) {
                name = "SELECT";
//                ReflectUtil.setFieldValue(boundSql, "sql", permissionSql(boundSql.getSql()));
            }
            //logger.info("sql {}----",boundSql.getSql());
            SysGlobalsqllog globalsqllog = new SysGlobalsqllog();
            try{
            	
                long start = System.currentTimeMillis();
                result =invocation.proceed();
                int resultCount = 0;
                if (result != null) {
                    if (result instanceof List) {
                        resultCount = ((List) result).size();
                    } else if (result instanceof Collection) {
                        resultCount = ((Collection) result).size();
                    } else {
                        resultCount = 1;
                    }
                } 
                long end = System.currentTimeMillis();
                SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
                if(user != null&&"INSERT,UPDATE,DELETE".indexOf(name)>-1 &&(mappedStatement.getId().indexOf("SysGlobalsqllogMapper")== -1||(mappedStatement.getId().indexOf("SysGlobalsqllogMapper")> -1&&!"INSERT".equals(name)))){
                    user.getUserName();
                    globalsqllog.setUserid(user.getUserName());
                    globalsqllog.setUsername(user.getName());
                    globalsqllog.setOperate(name);
                    globalsqllog.setExcutetime((end-start));
                    globalsqllog.setParams(JSONObject.toJSONString(boundSql.getParameterObject()));
                    globalsqllog.setMapperid(mappedStatement.getId());
                    globalsqllog.setSql(boundSql.getSql());
                    globalsqllog.setResultcount(resultCount);
                    SysGlobalsqllogMapper globalsqllogMapper = SpringUtil.getBean(SysGlobalsqllogMapper.class);
//                    globalsqllogMapper.insert(globalsqllog);
                }
            }catch(Exception e){
            	logger.error("发生异常{}", e.getMessage());
            }finally {
                return result;
            }
             
        }
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
    /**
     * 权限sql包装
     * @author GaoYuan
     * @date 2018/4/17 上午9:51
     */
    protected String permissionSql(String sql) {
        StringBuilder sbSql = new StringBuilder(sql);
        //当前登录人
        sbSql = new StringBuilder("select * from (").append(sbSql).append(" ) s where 1=1  ");

        return sbSql.toString();
    }

}