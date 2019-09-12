package com.fun.generator.utils;

import com.fun.generator.core.CodeGeneratorTool;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

/**
 * created by DJun on 2019/8/10 23:34
 * desc:
 */
public class FreemarkerUtil {
    private static final Logger logger = LoggerFactory.getLogger(CodeGeneratorTool.class);

    /**
     * freemarker config
     */
    private static Configuration freemarkerConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

    static {
        String templatePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int wei = templatePath.lastIndexOf("WEB-INF/classes/");
        if (wei > -1) {
            templatePath = templatePath.substring(0, wei);
        }

        try {
            freemarkerConfig.setDirectoryForTemplateLoading(new File(templatePath, "templates/xxl-code-generator"));
            freemarkerConfig.setNumberFormat("#");
            freemarkerConfig.setClassicCompatible(true);
            freemarkerConfig.setDefaultEncoding("UTF-8");
            freemarkerConfig.setLocale(Locale.CHINA);
            freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * process Template Into String
     */
    public static String processTemplateIntoString(Template template, Object model)
            throws IOException, TemplateException {

        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }

    /**
     * process String
     */
    public static String processString(String templateName, Map<String, Object> params)
            throws IOException, TemplateException {

        Template template = freemarkerConfig.getTemplate(templateName);
        return processTemplateIntoString(template, params);
    }

}
