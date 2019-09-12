package com.fun.generator.controller;

import com.fun.generator.core.CodeGeneratorTool;
import com.fun.generator.core.pojo.ClassInfo;
import com.fun.generator.model.ReturnT;
import com.fun.generator.utils.FreemarkerTool;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * created by DJun on 2019/8/10 22:55
 * desc:
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private FreemarkerTool freemarkerTool;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/codeGenerate")
    @ResponseBody
    public ReturnT<Map<String, String>> codeGenerate(String tableSql) {

        try {
            if (StringUtils.isBlank(tableSql)) {
                return new ReturnT<>(ReturnT.FAIL_CODE, "表结构信息不可为空");
            }

            // parse table
            ClassInfo classInfo = CodeGeneratorTool.processTableIntoClassInfo(tableSql);

            // code genarete
            Map<String, Object> params = new HashMap<>();
            params.put("classInfo", classInfo);

            // result
            Map<String, String> result = new HashMap<>();

            result.put("controller_code", freemarkerTool.processString("xxl-code-generator/controller.ftl", params));
            result.put("service_code", freemarkerTool.processString("xxl-code-generator/service.ftl", params));
            result.put("service_impl_code", freemarkerTool.processString("xxl-code-generator/service_impl.ftl", params));

            result.put("dao_code", freemarkerTool.processString("xxl-code-generator/dao.ftl", params));
            result.put("mybatis_code", freemarkerTool.processString("xxl-code-generator/mybatis.ftl", params));
            result.put("model_code", freemarkerTool.processString("xxl-code-generator/model.ftl", params));

            // 计算,生成代码行数
            int lineNum = 0;
            for (Map.Entry<String, String> item : result.entrySet()) {
                if (item.getValue() != null) {
                    lineNum += StringUtils.countMatches(item.getValue(), "\n");
                }
            }
            logger.info("生成代码行数：{}", lineNum);

            return new ReturnT<>(result);
        } catch (IOException | TemplateException e) {
            logger.error(e.getMessage(), e);
            return new ReturnT<>(ReturnT.FAIL_CODE, "表结构解析失败");
        }

    }
}
