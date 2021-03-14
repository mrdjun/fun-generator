package com.fun.demo.service.impl;

import com.fun.demo.dao.ProductMapper;
import com.fun.demo.model.Product;
import com.fun.demo.service.ProductService;
import com.fun.demo.util.Convert;
import com.fun.demo.util.PageInfoEvt;
import com.fun.demo.util.R;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品
 * @author fun
 * @date 2021-03-14
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /**
     * 新增商品
     *
     */
    @Override
    public R insert(Product product) {
        return productMapper.insert(product) > 0 ? R.success() : R.error();
    }

    /**
     * 删除商品
     *
     */
    @Override
    public R removeById(long userId) {
        return productMapper.deleteById(userId) > 0 ? R.success() : R.error();
    }

    /**
     * 通过id批量删除商品
     *
     */
    @Override
    public R removeByIds(String userIds) {
        return productMapper.deleteByIds(Convert.toStrArray(userIds))> 0 ? R.success() : R.error();
    }

    /**
     * 修改商品
     *
     */
    @Override
    public R edit(Product product) {
        return productMapper.update(product) > 0 ? R.success() : R.error();
    }

    /**
     * 通过Id查询商品
     *
     */
    @Override
    public Product getById(long userId) {
        return productMapper.selectById(userId);
    }

    /**
     * 分页查询商品
     *
     */
    @Override
    public List<Product> list(Product product, PageInfoEvt evt) {
        PageHelper.startPage(evt.getPageNum(), evt.getPageSize());
        return productMapper.selectList(product);
    }

}
