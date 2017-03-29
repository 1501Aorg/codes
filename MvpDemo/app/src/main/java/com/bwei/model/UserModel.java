package com.bwei.model;

import android.util.Log;

import com.bwei.bean.UserBean;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserModel implements IUserModel{
    private UserBean userBean;

    public UserModel() {
        this.userBean = new UserBean();
    }

    @Override
    public void setUserName(String userName) {
        userBean.setUserName(userName);
    }

    @Override
    public void setPassWord(String passWord) {
        userBean.setPassWord(passWord);
    }

    @Override
    public boolean login() {
        //把userBean的数据传递给服务器，进行登陆的查询判断
        String url = "http://169.254.63.148:8080/paoT/login";
        StringBuffer sb = new StringBuffer(url);
        sb.append("?username=" + userBean.getUserName());
        sb.append("&password=" + userBean.getPassWord());
        Log.d("TAG", sb.toString());
        //发送网络请求或者到本地sqlite
        if(userBean.getUserName().equals("admin") && userBean.getPassWord().equals("123456")){
            return true;
        }

        return false;
    }

    @Override
    public boolean regist() {

        //把userBean的数据传递给服务器，进行登陆的查询判断
        String url = "http://169.254.63.148:8080/paoT/regist";
        StringBuffer sb = new StringBuffer(url);
        sb.append("?username=" + userBean.getUserName());
        sb.append("&password=" + userBean.getPassWord());
        Log.d("TAG", sb.toString());
        //发送网络请求或者到本地sqlite
        boolean registRs = false;//把数据传递到服务器进行注册的结果


        return registRs;
    }


}
