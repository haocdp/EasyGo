package com.unicorn.easygo.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.maps.model.Text;
import com.unicorn.easygo.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_register = (TextView) findViewById(R.id.tvRegister);
        tv_register.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRegister:
                Intent intent = new Intent(this, RegisterActivity.class);
                this.startActivity(intent);
        }
    }
}
