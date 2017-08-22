package com.example.pc_.seller.database;

import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;

import java.util.List;

/**
 * Created by pc- on 2017/7/9.
 */
public class LiteOrmManager {


    public  Context context;
    public LiteOrm liteOrm;

    public static  LiteOrmManager liteOrmManager;
    public static  LiteOrmManager newInstance(Context context){
        if(liteOrmManager==null){
            synchronized (LiteOrmManager.class){
                if(liteOrmManager==null){
                    liteOrmManager=new LiteOrmManager(context);
                }

            }
        }
        return liteOrmManager;
    }
    public LiteOrmManager(Context context){
        DataBaseConfig config = new DataBaseConfig(context.getApplicationContext(), "liteOrm.db");
        config.dbVersion = 1;
        config.onUpdateListener = null;
        liteOrm = LiteOrm.newSingleInstance(config);
    }


//    public void save(OrderItem orderItem){
//        liteOrm.save(orderItem);
//    }
//    public void update(OrderItem orderItem){
//       liteOrm.update(orderItem);
//   }
    public <T> List<T> getQueryAll(Class<T> cla) {
        return liteOrm.query(cla);
    }

    public void save(Object object,int i){
        if(i==1){
            liteOrm.save((OrderModel) object);
        }else if(i==2){
            liteOrm.save((ChangePriceModel) object);
        }
    }

    public void update(Object object,int i){
        if(i==1){
            liteOrm.update((OrderModel) object);
        }else if(i==2){
            liteOrm.update((ChangePriceModel) object);
        }
    }
}
