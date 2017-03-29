package com.bwei.model;

/**
 * Created by Administrator on 2017/3/24.
 */

public interface IUserModel {

    void setUserName(String userName) ;

    void setPassWord(String passWord) ;

    boolean login();

    boolean regist();
}
