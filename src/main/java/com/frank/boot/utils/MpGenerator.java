package com.frank.boot.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.frank.boot.domain.system.SysCodegenConfig;
import com.frank.boot.domain.system.SysDatasource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MpGenerator {
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;
    @Value("${spring.datasource.dynamic.datasource.master.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;
    public SysDatasource getDefaultDataSource(){
        SysDatasource sysDatasource = new SysDatasource();
        sysDatasource.setId(1);
        sysDatasource.setName("master");
        sysDatasource.setDriver(driver);
        sysDatasource.setUsername(username);
        sysDatasource.setPassword(password);
        sysDatasource.setUrl(url);
        return sysDatasource;
    }

    public static void generateByTables(String packageName, SysCodegenConfig codegenConfig) {
        GlobalConfig config = new GlobalConfig();
        SysDatasource sysDatasource = codegenConfig.getSysDatasource();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        if("com.mysql.jdbc.Driver".equals(sysDatasource.getDriver())){
            dataSourceConfig.setDbType(DbType.MYSQL);
        }else if("oracle.jdbc.driver.OracleDriver".equals(sysDatasource.getDriver())
                ||"oracle.jdbc.OracleDriver".equals(sysDatasource.getDriver())){
            dataSourceConfig.setDbType(DbType.ORACLE);
        }

        dataSourceConfig.setUrl(sysDatasource.getUrl())
                .setUsername(sysDatasource.getUsername())
                .setPassword(sysDatasource.getPassword())
                .setDriverName(sysDatasource.getDriver());
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(codegenConfig.getTableName());//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor(codegenConfig.getAuthor())
                .setOutputDir(codegenConfig.getOutpath())
                .setFileOverride(true).setServiceName("%sService");;
        String moduleName = codegenConfig.getModule();


        InjectionConfig cfg = new InjectionConfig() {
          @Override
          public void initMap() {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("ModuleName",moduleName);
            map.put("codeTypes",codegenConfig.getGenType());
              Map<String,Object> params = new HashMap();
              if(!StringUtils.isEmpty(codegenConfig.getQueryParams())){
                  params = resolveQueryPamras(codegenConfig.getQueryParams());
              }
            map.putAll(params);
            this.setMap(map);
          }
        };
        new AutoGenerator().setGlobalConfig(config)
            .setDataSource(dataSourceConfig)
            .setStrategy(strategyConfig)
            .setPackageInfo(
                new PackageConfig()
                    .setParent(packageName)
                    .setController("controller."+moduleName)
                    .setService("service."+moduleName)
                    .setServiceImpl("service."+moduleName+".impl")
                    .setMapper("dao."+moduleName)
                    .setEntity("domain."+moduleName)
                    .setXml("mapper."+moduleName)
            ).setCfg(cfg).execute();
    }

    /**
     * selectList::table_name@@like,module@@eq|||selectPager::table_name@@like
     * @param paramStr
     * @return
     */
    private static Map<String,Object> resolveQueryPamras(String paramStr){
        Map<String,Object> queryMap = new HashMap<>();
        String [] codeTypeParms = paramStr.split("\\|\\|\\|");
        for(String param : codeTypeParms){
            String queryKey = param.split("::")[0];
            String params = param.split("::")[1];
            queryMap.put(queryKey,params);
        }
        return queryMap;
    }
}
