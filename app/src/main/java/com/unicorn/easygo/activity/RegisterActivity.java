package com.unicorn.easygo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unicorn.easygo.R;
import com.unicorn.easygo.db.userDBdao;

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private EditText userName;//账号
    private EditText passWord;//密码
    private Button btnRegister;//注册

    private String name;
    private String pwd;
    private userDBdao userDBdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText)findViewById(R.id.edtTxtUsernameInRegister);
        passWord = (EditText)findViewById(R.id.edtTxtPasswordInRegister);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnRegister:
                name=userName.getText().toString();
                pwd=passWord.getText().toString().trim();

                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "账户名不能为空！",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                if (pwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "密码不能为空！",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                userDBdao = new userDBdao(getApplicationContext());
                userDBdao.add(name,pwd);
                Toast.makeText(getApplicationContext(), "注 册 成 功 ！",
                        Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}