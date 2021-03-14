package com.fun.generator.controller;

import com.fun.generator.model.ClassInfo;
import com.fun.generator.model.R;
import com.fun.generator.util.FreemarkerTool;
import com.fun.generator.util.TableParseUtil;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * sso server (for web)
 *
 * @author xuxueli 2017-08-01 21:39:47
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private FreemarkerTool freemarkerTool;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/codeGenerate")
    @ResponseBody
    public R codeGenerate(String tableSql) {
        try {
            if (StringUtils.isBlank(tableSql)) {
                return R.error("表结构信息不可为空");
            }
            ClassInfo classInfo = TableParseUtil.processTableIntoClassInfo(tableSql);

            Map<String, Object> params = new HashMap<>();
            params.put("classInfo", classInfo);
            Map<String, String> result = new HashMap<>();

            result.put("controller_code", freemarkerTool.processString("xxl-code-generator/controller.ftl", params));
            result.put("service_code", freemarkerTool.processString("xxl-code-generator/service.ftl", params));
            result.put("service_impl_code", freemarkerTool.processString("xxl-code-generator/service_impl.ftl", params));
            result.put("dao_code", freemarkerTool.processString("xxl-code-generator/dao.ftl", params));
            result.put("mybatis_code", freemarkerTool.processString("xxl-code-generator/mybatis.ftl", params));
            result.put("model_code", freemarkerTool.processString("xxl-code-generator/model.ftl", params));

            return R.success(result);
        } catch (IOException | TemplateException e) {
            logger.error(e.getMessage(), e);
            return R.error("表结构解析失败");
        }
    }
}