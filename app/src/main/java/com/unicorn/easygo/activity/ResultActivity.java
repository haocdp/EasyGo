package com.unicorn.easygo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;

/**
 * Created by guojishan on 2017/6/14.
 */

public class ResultActivity extends AppCompatActivity {

    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private TextView result;
    private String content;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        result = (TextView)findViewById(R.id.result);
        Intent intent = getIntent();
        String data = intent.getStringExtra("codedContent");
        result.setText("解码结果： \n" + data);
//            TextView title = (TextView)findViewById(R.id.result);
//            title.setText("扫描结果");
//            FontUtil.setFont(title,this.getAssets(),0);
}
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // 扫描二维码/条码回传
//        if (resultCode == RESULT_OK) {
//            if (data != null) {
//                String content = data.getStringExtra("codedContent");
//                //Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
//                Log.i("ResultActivity",content);
//                //result.setText("解码结果： \n" + content);
//
////                Intent intent = new Intent();
////                intent.setAction("android.intent.action.VIEW");
////                Uri content_url = Uri.parse(content.toString());
////                intent.setData(content_url);
////                startActivity(intent);
//                return content;
//            }
//        }
//    }
}
