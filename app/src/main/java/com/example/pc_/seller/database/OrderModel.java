package com.example.pc_.seller.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by pc- on 2017/8/15.
 */
@Table("OrderModel")
public class OrderModel {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    public int id;


    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Column("OrderTime")
    public String orderTime;

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    @Column("OrderContent")
    public String orderContent;

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    @Column("IsSend")
    public boolean isSend;
}
