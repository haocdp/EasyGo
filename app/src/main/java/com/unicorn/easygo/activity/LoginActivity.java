package com.unicorn.easygo.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.model.Text;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.MainActivity;
import com.unicorn.easygo.R;
import com.unicorn.easygo.db.user;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.entity.UserProfile;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_register;
    private user user;
    userDBdao userdbdao;
    private EditText loginName;// 账号
    private EditText loginPwd;// 密码
    private Button login;//登陆

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_register = (TextView) findViewById(R.id.tvRegister);
        loginName = (EditText) this.findViewById(R.id.edtTxtUsername);
        loginName.setFocusable(true); //自动获得焦点
        loginName.setFocusableInTouchMode(true); //触摸模式下自动获得焦点

        loginPwd = (EditText) this.findViewById(R.id.edtTxtPassword);
        loginName.setFocusable(true); //自动获得焦点
        loginName.setFocusableInTouchMode(true); //触摸模式下自动获得焦点
        login = (Button) this.findViewById(R.id.btnLogin);
        tv_register.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        tv_register.setOnClickListener(this);
        login.setOnClickListener(this);


        loginName.setOnFocusChangeListener(this);
        loginPwd.setOnFocusChangeListener(this);
        //loginName.requestFocus();

    }

//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRegister:
                Intent intent = new Intent(this, RegisterActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btnLogin:
                if (loginName.getText().toString().trim().equals("")) 	{
                    Toast.makeText(getApplicationContext(), "账户名不能为空！",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                if (loginPwd.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "密码不能为空！",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                userdbdao = new userDBdao(getApplicationContext());
                boolean result = userdbdao.find(loginName.getText().toString());
                if(result){//判断账号是否存在
                    result = userdbdao.findLogin(loginName.getText().toString(),loginPwd.getText().toString());
                    if(result){//若账号存在，判断密码是否正确
                        Intent login_intent = new Intent(this,MainActivity.class);
                        login_intent.putExtra("name", loginName.getText	().toString().trim());
                        startActivity(login_intent);

                    }else{
                        Toast.makeText(getApplicationContext(),"密码错误，请重试",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"账号不存在！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
