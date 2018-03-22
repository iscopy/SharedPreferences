package com.win.sharedprefences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/3/22 0022.
 * 保存一些简单的数据
 */

public class MySharedPreferences {

    //创建一个SharedPreferences    类似于创建一个数据库，库名为 data
    public static SharedPreferences share(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("date", Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    //name 账号
    //调用上面的 share(Context context) 方法 获取标识为 "name" 的数据
    public static Object getName(Context context){
        return share(context).getString("name",null);
    }
    //调用上面的 share(Context context) 方法 将数据存入，并标识为 "name"
    //使用 commit() 方法保存会给出反应（保存成功或失败）
    public static boolean setName(String name, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("name",name);
        Boolean bool = e.commit();
        return bool;
    }

    //pswd 密码
    public static String getPswd(Context context){
        return share(context).getString("pswd",null);
    }
    //这里使用的是 apply() 方法保存，将不会有返回值
    public static void setPswd(String pswd, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("pswd",pswd);
        e.apply();
    }

    /**
     * 可以根据需求选择用那种方式保存数据
     * （需不需要告诉你有没有保存成功）
     */

    //sex 性别
    public static String getSex(Context context){
        return share(context).getString("sex",null);
    }
    public static void setSex(String sex, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("sex",sex);
        e.apply();
    }

    //age 年龄
    public static String getAge(Context context){
        return share(context).getString("age",null);
    }
    public static void setAge(String age, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("age",age);
        e.apply();
    }

}
