package com.fun.generator.core;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * created by DJun on 2019/8/10 23:32
 * desc:
 */
@Component
public class FreemarkerTool {
//    private static final Logger logger = LoggerFactory.getLogger(CodeGeneratorTool.class);

    @Autowired
    private Configuration configuration;

    /**
     * process Template Into String
     *
     */
    public String processTemplateIntoString(Template template, Object model)
            throws IOException, TemplateException {

        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }

    /**
     * process String
     */
    public String processString(String templateName, Map<String, Object> params)
            throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        return processTemplateIntoString(template, params);
    }
}
