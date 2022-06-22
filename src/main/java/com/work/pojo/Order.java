package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Id;

@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 订单号
     * 下单客户
     * 订单金额
     * 是否使用优惠券
     * 是否使用餐桌
     * **/
    @Id
    private String orderNum;
    private String customer;
    private Double price;
    private Integer useCoupon;
    private Integer useTable;

}
