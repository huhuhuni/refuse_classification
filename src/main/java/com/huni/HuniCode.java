package com.huni;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class HuniCode {
    //需要构建一个代码构建器对象
    public static void main(String[] args) {
        AutoGenerator autoGenerator=new AutoGenerator();
        //配置策略
        //1,全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("huni");
        globalConfig.setOpen(false);//是否打开资源管理器
        globalConfig.setFileOverride(true);//是否覆盖原来的；
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setServiceName("%sService");//去service的I前缀
        globalConfig.setDateType(DateType.ONLY_DATE);
        //globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);
        //2，设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/laji?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);
        //3，包的设置
        PackageConfig packageConfig = new PackageConfig();
        //packageConfig.setModuleName("laji");
        packageConfig.setParent("com.huni");
        packageConfig.setEntity("pojo");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);
        //4,策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("admin");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        //strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充配置
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        //TableFill gmtModified = new TableFill("gmt_modifield", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        //tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        //乐观锁
        //strategy.setVersionFieldName("version");

        //strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategy);

        autoGenerator.execute();
    }

}