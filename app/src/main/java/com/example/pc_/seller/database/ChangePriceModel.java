package com.example.pc_.seller.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by pc- on 2017/8/16.
 */
@Table("OrderModel")
public class ChangePriceModel {

     @PrimaryKey(AssignType.AUTO_INCREMENT)
     public int id;


        public int getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(int goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        @Column("GoodsPrice")
        public int goodsPrice;

        public int getGoodsSell() {
            return goodsSell;
        }

        public void setGoodsSell(int goodsSell) {
            this.goodsSell = goodsSell;
        }

        @Column("GoodsSell")
        public int goodsSell;

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        @Column("GoodsName")
        public String goodsName;




}
