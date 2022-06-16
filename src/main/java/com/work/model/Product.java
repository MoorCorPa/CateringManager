package com.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * 商品名
     * 库存
     * 图片
     * 价格
     * **/
    private String pName;
    private int reserve;
    private String imgUrl;
    private double price;
}
