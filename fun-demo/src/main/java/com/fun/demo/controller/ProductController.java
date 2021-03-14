package com.fun.demo.model.controller;

import com.fun.demo.model.Product;
import com.fun.demo.service.ProductService;
import com.fun.demo.util.PageInfoEvt;
import com.fun.demo.util.R;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


@Api(tags = "商品")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation("新增商品")
    @PostMapping("/insert")
    public R insert(Product product){
        return productService.insert(product);
    }


    @ApiOperation("通过id删除商品")
    @PostMapping("/removeById/{userId}")
    public R removeById(@PathVariable("userId") Long userId){
        return productService.removeById(userId);
    }


    @ApiOperation("通过id批量删除商品")
    @PostMapping("/removeByIds")
    public R removeByIds(String userIds) {
        return productService.removeByIds(userIds);
    }


    @ApiOperation("修改商品")
    @PostMapping("/edit")
    public R edit(Product product){
        return productService.edit(product);
    }

    @ApiOperation("通过Id查询商品")
    @PostMapping("/getById/{userId}")
    public R getById(Long userId){
        return R.success(productService.getById(userId));
    }


    @ApiOperation("查询商品列表")
    @PostMapping("/list")
    public R pageList(Product product,PageInfoEvt evt) {
        PageInfo<Product> pageInfo = new PageInfo<>();
        pageInfo.setList(productService.list(product, evt));
        return R.success(pageInfo);
    }

}
