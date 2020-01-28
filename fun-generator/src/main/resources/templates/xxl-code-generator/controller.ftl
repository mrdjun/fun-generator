package com.fun.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

import com.fun.common.result.CommonResult;
import com.fun.project.entity.${classInfo.className};
import com.fun.project.service.I${classInfo.className}Service;
import com.fun.pagehelper.CommonPage;

import java.util.List;

/**
 * @author DJun
 * @date ${.now?string('yyyy/MM/dd')}
 */
@Api("${classInfo.classComment}")
@Controller
@RequestMapping("/${classInfo.className?uncap_first}")
public class ${classInfo.className}Controller {

    @Autowired
    private I${classInfo.className}Service ${classInfo.className?uncap_first}Service;


    @ApiOperation(" 查询${classInfo.classComment}列表")
    @PostMapping("/select${classInfo.className}List")
    @ResponseBody
    public CommonResult select${classInfo.className}List(${classInfo.className} ${classInfo.className?uncap_first},
                                        @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        List<${classInfo.className}> ${classInfo.className?uncap_first}s = ${classInfo.className?uncap_first}Service.select${classInfo.className}List(${classInfo.className?uncap_first},pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(${classInfo.className?uncap_first}s));
    }

    @ApiOperation("通过Id查询${classInfo.classComment}")
    @GetMapping("/select${classInfo.className}ById/${r"{"}${classInfo.conversionPrimaryKey}${r"}"}")
    @ResponseBody
    public CommonResult select${classInfo.className}ById(@PathVariable("${classInfo.conversionPrimaryKey}") Long ${classInfo.conversionPrimaryKey}){
        return CommonResult.success(${classInfo.className?uncap_first}Service.select${classInfo.className}ById(${classInfo.conversionPrimaryKey}));
    }

    @ApiOperation("新增${classInfo.classComment}")
    @PostMapping("/insert${classInfo.className}")
    @ResponseBody
    public CommonResult insert${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first}){
        return CommonResult.success(${classInfo.className?uncap_first}Service.insert${classInfo.className}(${classInfo.className?uncap_first}));
    }


    @ApiOperation("修改${classInfo.classComment}信息")
    @PostMapping("/update${classInfo.className}")
    @ResponseBody
    public CommonResult update${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first}){
        return CommonResult.success(${classInfo.className?uncap_first}Service.update${classInfo.className}(${classInfo.className?uncap_first}));
    }

    @ApiOperation("通过id删除${classInfo.classComment}")
    @PostMapping("/delete${classInfo.className}ById/${r"{"}${classInfo.conversionPrimaryKey}${r"}"}")
    @ResponseBody
    public CommonResult delete${classInfo.className}ById(@PathVariable("${classInfo.conversionPrimaryKey}") Long ${classInfo.conversionPrimaryKey}){
        return CommonResult.success(${classInfo.className?uncap_first}Service.delete${classInfo.className}ById(${classInfo.conversionPrimaryKey}));
    }

    @ApiOperation("通过id批量删除${classInfo.classComment}")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult delete${classInfo.className}ByIds(String ${classInfo.conversionPrimaryKey}s){
        return CommonResult.success(${classInfo.className?uncap_first}Service.delete${classInfo.className}ByIds(${classInfo.conversionPrimaryKey}s));
    }
}
