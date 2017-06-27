package com.unicorn.easygo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;

public class ScanShoppingCartActivity extends AppCompatActivity {

    private TextView title;
    private TextView shoppingCartNo;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scan_shopping_cart_result);

        title = (TextView) findViewById(R.id.title_text);
        shoppingCartNo = (TextView) findViewById(R.id.shoppingCartNo);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
        String scNo = intent.getStringExtra("shoppingCartNo").split("-")[1];
        shoppingCartNo.setText(scNo);
        EGOApplication.getInstance().setHasBundCart(true);
        EGOApplication.getInstance().setShoppingCartNo(scNo);
        title.setText(getString(R.string.haveAScan));

        setFonts();
    }

    private void setFonts() {
        FontUtil.setFont(title, this.getAssets(), 0);
        FontUtil.setFont(shoppingCartNo, this.getAssets(), 0);
        FontUtil.setFont(textView, this.getAssets(), 0);
        FontUtil.setFont(textView2, this.getAssets(), 0);
    }
}
