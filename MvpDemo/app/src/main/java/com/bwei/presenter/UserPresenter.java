package com.bwei.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.bwei.model.IUserModel;
import com.bwei.model.UserModel;
import com.bwei.mvpdemo.MainActivity;
import com.bwei.mvpdemo.SuccessActivity;
import com.bwei.view.IUserView;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserPresenter {
    private IUserView userView;
    private IUserModel userModel;

    public UserPresenter(IUserView userView) {
        this.userView = userView;
        this.userModel = new UserModel();
    }

    /**
     * 登陆功能的业务逻辑
     */
    public void login(){

        //首先把页面的用户名和密码封装到UserModel里
        if(userView.getUserName() == null || userView.getUserName() == ""){
                Toast.makeText((Activity)userView, "用户名不能为空", Toast.LENGTH_LONG).show();
                return;
        }
        if(userView.getPassWord() == null || userView.getPassWord() == ""){
            Toast.makeText((Activity)userView, "密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        userModel.setUserName(userView.getUserName());
        userModel.setPassWord(userView.getPassWord());
        //到model层的功能方法
        boolean loginResult = userModel.login();
        if(loginResult){
            //跳转到成功页面
            MainActivity mainActivity = (MainActivity)userView;
            Intent intent = new Intent(mainActivity, SuccessActivity.class);
            mainActivity.startActivity(intent);
        }else{
            Toast.makeText(((Activity)userView).getApplication(), "账号错误，请求重试", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 注册功能
     */
    public void regist(){

        //首先把页面的用户名和密码封装到UserModel里
        if(userView.getUserName() == null || userView.getUserName() == ""){
            Toast.makeText((Activity)userView, "用户名不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        if(userView.getPassWord() == null || userView.getPassWord() == ""){
            Toast.makeText((Activity)userView, "密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        userModel.setUserName(userView.getUserName());
        userModel.setPassWord(userView.getPassWord());
        //到model层的功能方法
        ;
        if(userModel.regist()){
            //跳转到成功页面
            MainActivity mainActivity = (MainActivity)userView;
            Intent intent = new Intent(mainActivity, SuccessActivity.class);
            mainActivity.startActivity(intent);
        }else{
            Toast.makeText(((Activity)userView).getApplication(), "注册失败，请求重试", Toast.LENGTH_SHORT).show();
        }

    }



}
