package com.bwei.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.presenter.UserPresenter;
import com.bwei.view.IUserView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements IUserView{

    private EditText userName;
    private EditText passWord;
    @BindViews({R.id.login, R.id.regist})
    public List<Button> buttonList;

    public Button regist;
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册eventBus
        EventBus.getDefault().register(this);
        //绑定butternifer
        ButterKnife.bind(this);
        //获得组件
        initView();

//        findViewById(R.id.but1).setOnClickListener(this);
//        findViewById(R.id.but2).setOnClickListener(this);
//        findViewById(R.id.but3).setOnClickListener(this);
//        findViewById(R.id.but4).setOnClickListener(this);

    }

    private void initView() {
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.passWord);
//        login = (Button) findViewById(R.id.login);
//        regist = (Button) findViewById(R.id.regist);

        buttonList.get(0).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //通过p把v层（layout+activity）和model层结合
                userPresenter =  new UserPresenter(MainActivity.this);
                userPresenter.login();
            }
        });

        buttonList.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过p把v层（layout+activity）和model层结合
                userPresenter =  new UserPresenter(MainActivity.this);
                Toast.makeText(MainActivity.this, "点击了login", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public String getUserName() {
        return userName.getText().toString().trim();
    }

    @Override
    public void setUserName(String userName) {
        this.userName.setText(userName);
    }

    @Override
    public String getPassWord() {
        return passWord.getText().toString().trim();
    }

    @Override
    public void setPassWord(String passWord) {
        this.passWord.setText(passWord);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FirstEvent event){
        Toast.makeText(this, "接收消息：" + event.getMsg(), Toast.LENGTH_LONG).show();
    }

}
