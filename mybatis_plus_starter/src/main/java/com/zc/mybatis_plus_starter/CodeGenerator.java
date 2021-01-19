package com.zc.mybatis_plus_starter;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
//        if(projectPath != null){
//            return;
//        }
        //文件输出的位置
        gc.setOutputDir(projectPath + "/spring_security_demo/src/main/java");
        System.out.println(gc.getOutputDir());
        gc.setAuthor("zc");
        //是否打开输出目录
        gc.setOpen(false);
        gc.setDateType(DateType.TIME_PACK);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        //是否覆盖已有文件
        gc.setFileOverride(false);
        //去掉Service接口的首字母I
        gc.setServiceName("%sService");


        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/vote?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        //在有schema的情况下，需要指定好目标 ，db2中测试必须有''，mysql暂时不清楚
        // dsc.setSchemaName("'public'");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent("com.zc.spring_security_demo");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");

        //指定生成文件的绝对路径-------
//        Map<String, String> pathInfo  = new HashMap<>();
//        String parentPath = "\\src\\main\\java\\com\\zc\\mybatis_plus_demo\\";
//        String conStr ="\\mybatis_plus_demo";
//
//        String entityPath = projectPath.concat(conStr).concat(parentPath).concat("entity");
//        String mapper_path = projectPath.concat(conStr).concat(parentPath).concat("mapper");
//        String xml_path = projectPath.concat(conStr).concat("\\src\\main\\resources\\mapper");
//        String service_path = projectPath.concat(conStr).concat(parentPath).concat("service");
//        String service_impl_path = projectPath.concat(conStr).concat(parentPath).concat("serviceImpl");
//        String controller_path = projectPath.concat(conStr).concat(parentPath).concat("controller");
//
//        pathInfo.put("entity_path",entityPath);
//        pathInfo.put("mapper_path",mapper_path);
//        pathInfo.put("xml_path",xml_path);
//        pathInfo.put("service_path",service_path);
//        pathInfo.put("service_impl_path",service_impl_path);
//        pathInfo.put("controller_path",controller_path);
//        pc.setPathInfo(pathInfo);
        //------------------------------
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 输出xml文件的目录
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/spring_security_demo/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
         templateConfig.setController("template/controller.java.vm");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置自动填充,也可以class配置
        TableFill tableFill  = new TableFill("created_at",FieldFill.INSERT);
        TableFill tableFill1  = new TableFill("updated_at",FieldFill.INSERT_UPDATE);
        List<TableFill> tableFillList = new ArrayList<TableFill>(){{
             add(tableFill);
             add(tableFill1);
        }
        };

        strategy.setTableFillList(tableFillList);
        //设置version字段是乐观锁字段
        strategy.setVersionFieldName("version");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段,注释掉不然生成的entity中没有id字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

}