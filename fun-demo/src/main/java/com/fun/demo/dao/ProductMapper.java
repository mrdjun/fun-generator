package com.fun.demo.dao;

import com.fun.demo.model.Product;

import java.util.List;

/**
 * 商品
 * @author fun
 * @date 2021-03-14
 */
public interface ProductMapper {

    /**
     * 新增商品
     *
     */

    int insert(Product product);

    /**
     * 删除商品
     *
     */
    int deleteById( long userId);


    /**
     * 通过id批量删除商品
     *
     */
    int deleteByIds(String[] userIds);



    /**
     * 修改商品
     *
     */
    int update(Product product);


    /**
     * 通过Id查询商品
     *
     */
    Product selectById(long userId);


    /**
     * 分页查询商品
     *
     */
    List<Product> selectList(Product product);



}
