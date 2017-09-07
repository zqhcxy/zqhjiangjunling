package com.jiangjunling.zqh.zqhjiangjunling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiangjunling.zqh.zqhjiangjunling.util.Utils;

public class ShowKeyActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView showKey_tv;
    private EditText showKey_find_key;
    private Button showkey_btn;
    private Button showkey_addkey_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_key);

        initView();
    }

    private void initView(){
        showKey_tv=(TextView)findViewById(R.id.showKey_tv);
        showKey_find_key=(EditText)findViewById(R.id.showKey_find_key);
        showkey_btn=(Button)findViewById(R.id.showkey_btn);
        showkey_addkey_btn=(Button)findViewById(R.id.showkey_addkey_btn);

        showkey_btn.setOnClickListener(this);
        showkey_addkey_btn.setOnClickListener(this);
        showKey_find_key.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length=showKey_find_key.getText().length();
                if(length>0){
                    showkey_btn.setEnabled(true);
                }else{
                    showkey_btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showkey_btn://find key
                String key=showKey_find_key.getText().toString();
                String value= Utils.getStringFromSharepreference(this,key);
                if(TextUtils.isEmpty(value)){
                    showKey_tv.setText(getResources().getString(R.string.show_key_fail_text));
                }else{
                    showKey_tv.setText(value);
                }
                showKey_find_key.setText("");
                break;
            case R.id.showkey_addkey_btn://add key
                Intent intent=new Intent(ShowKeyActivity.this,MainActivity.class);
                intent.putExtra(MainActivity.TYPEKEY,MainActivity.ADDKEY_TYPR);
                startActivity(intent);
                break;
        }
    }
}
