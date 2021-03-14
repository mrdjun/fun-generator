package com.fun.demo.service;

import com.fun.demo.model.Product;
import com.fun.demo.util.PageInfoEvt;
import com.fun.demo.util.R;

import java.util.List;

/**
 * 商品
 * @author fun 2021-03-14
 */
public interface ProductService {

    /**
     * 新增商品
     *
     */
    R insert(Product product);

    /**
     * 删除商品
     *
     */
    R removeById(long userId);

    /**
     * 通过id批量删除商品
     *
     */
    R removeByIds(String userIds);

    /**
     * 修改商品
     *
     */
    R edit(Product product);

    /**
     * 通过Id查询商品
     *
     */
    Product getById(long userId);

    /**
     * 分页查询商品
     *
     */
    List<Product> list(Product product, PageInfoEvt evt);
}
