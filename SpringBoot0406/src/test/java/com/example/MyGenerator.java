package com.example;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;

public class MyGenerator {

    public static void main(String[] args) {
        // 表名
        String tableName = "cost_user";
        // 创建生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        // 获取项目路径
        String baseDir = System.getProperty("user.dir");

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(baseDir + "/src/main/java");
        globalConfig.setAuthor("lhw199911");
        globalConfig.setOpen(false);
        globalConfig.setServiceName("%sService"); // 去除Service生成名称的第一个字母I

        // 数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://192.168.80.121:3307/ActualCombat?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example");
        HashMap<String, String> pathMap = new HashMap<>();
        pathMap.put("entity_path", baseDir + "/src/main/java/com/example/entity");
        pathMap.put("service_path", baseDir + "/src/main/java/com/example/service");
        pathMap.put("service_impl_path", baseDir + "/src/main/java/com/example/service/impl");
        pathMap.put("mapper_path", baseDir + "/src/main/java/com/example/mapper");
        pathMap.put("controller_path", baseDir + "/src/main/java/com/example/controller");
        pathMap.put("xml_path", baseDir + "/src/main/resources/com/example/mapper");
        packageConfig.setPathInfo(pathMap); // 配置具体路径

        // 策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 下划线转驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true); //是否添加lombok注解
        strategyConfig.setRestControllerStyle(true); // 是否添加@RestController：使类作为控制器类，同时使所有方法返回对象为Json格式数据
        strategyConfig.setInclude(tableName);

        // 配置模板
        FreemarkerTemplateEngine freemarkerTemplateEngine = new FreemarkerTemplateEngine();

        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(freemarkerTemplateEngine);

        // 执行代码生成
        autoGenerator.execute();
    }
}
