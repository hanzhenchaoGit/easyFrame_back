# bootEasyFrame使用说明
## 前端代码  
https://github.com/hanzhenchaoGit/easyframe-front
## 后端代码
https://github.com/hanzhenchaoGit/easyFrame-back
## 框架使用技术总览
shiro权限控制  
cxfwebservice  
redis缓存: 主要用于存储session  
fastJson  
mongodb: 文件存储  
druid  
mybatis plus 
kaptcha验证码  
poi  
commons-jexl3:字符串反射为代码  
quartz: 定时作业,暂时只支持class的定时调用  
velocity: 模板引擎,主要用于代码生成模板解析

## 系统环境配置
application.properties 
spring.profiles.active=@env@ 与pom中的maven profile关联，控制不同环境下的变量参数
注:如果是不需要区分dev/pro/test环境，如端口、扫描包路径等变量都可配置在此文件
如果区分不同环境,变量需按照环境配置在如下的配置文件中
application-dev.properties --开发环境
application-test.properties --测试环境
.properties --生产环境

## webservice
### 发布
imlementor 直接写类或@Service("ImpId")
<jaxws:endpoint implementor="#ImpId" address="/test/web"></jaxws:endpoint>
### 外部webservice引用
id属性必填 
serviceClass配置wsdl生成的存根代码 代码一般封装到一个外部调用的webservice jar中方便管理 
address外部service的wsdl地址  
<jaxws:client  id="ddd" serviceClass="com.frank.boot.remote.ExportWebservice" address="http://localhost:8081/webservice/test/export?wsdl">
</jaxws:client>  
ws权限认证 添加了SecurityInteceptor拦截器，对webservice的请求头进行解析校验，可按需修改  
**在shiro拦截器配置中需要将webservice配置的上下文加到拦截其中进行忽略(anon)


## 代码生成
前端页面可直接配置生成逻辑,生成代码的核心Bean com.frank.boot.utils.MpGenerator
可生成Controller、Service、ServiceImpl、Dao、Mapper.xml   
**Controller**:包含增删改查,查询包含分页查询和不分页查询列表,都可在前端配置查询的参数逻辑,按照配置生成代码  
**Service**:继承了核心的IService,实现了单表增删改查的各种方法,完全可以满足需求  
**ServiceImpl**:Service的实现,可添加自己的实现接口  
**Dao**:生成的Dao已继承了单表操作的通用方法,如果dao的方法无法满足,可通过以下途径进行  
1.简单的增删改查可以通过mybatis注解的方式进行操作,使用@Select @Update @Insert @Delete等相关注解进行操作,注解中也支持xml中的动态语句拼接
2.普通多表查询可以通过注解查询的方式,无法反射到javaBean上的时候可以返回List<Map>类型的通用结果集
2.多个表关联,查询逻辑过于复杂的情况下,可以在mapper.xml中编写代码。 

## 部署
1.使用内置的tomcat使用springboot默认的写法就可以了  
2.使用独立tomcat部署则需修改启动类
```java
public class BootApplication extends SpringBootServletInitializer {
    public static void main(String [] args){
        SpringApplication.run(BootApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(BootApplication.class);
    }
}
```
pom.xml
<!--spring boot tomcat（默认可以不用配置，但当需要把当前web应用布置到外部servlet容器时就需要配置，并将scope配置为provided）-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
打包方式改为war,部署时直接放在tomcat的webapp目录下,tomcat启动会自动部署


数据库：
mysql 在windows环境下在查询字符串时忽略大小写 修改为敏感大小写my-default.ini lower-case-table-names=0 重启mysql服务

安装canal starter
mvn install:install-file -DgroupId=com.wwjd.canal -DartifactId=starter-canal -Dversion=1.0.0 -Dpackaging=jar -Dfile=./starter-canal-1.0.0.jar

## 项目启动
前端使用的花裤衩大佬的前端框架做的开发  
下载依赖: npm i  
启动开发: npm run dev  
后端自己将比较流行的技术框架使用springboot集成起来
首先使用resources下的frame_init.sql初始化项目所需的数据库环境

后端推荐使用idea导入maven项目后,配置好jdk1.8,直接使用BootApplication启动类进行启动  
启动前先安装redis mongodb canal(数据库同步中间件可以按照业务需求开启,不需要的话只需要将启动类的注解注释即可)

