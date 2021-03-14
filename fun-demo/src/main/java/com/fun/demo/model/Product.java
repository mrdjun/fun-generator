package com.fun.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品
 * @author fun
 * @date 2021-03-14
 */

public class Product implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     *
     */
    private Long id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     *
     */
    private String staus;

    /**
     * 数量
     */
    private int number;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}