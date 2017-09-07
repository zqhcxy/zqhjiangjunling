package com.jiangjunling.zqh.zqhjiangjunling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jiangjunling.zqh.zqhjiangjunling.util.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int DEFART_TYPR=0;
    public static final int ADDKEY_TYPR=1;

    public static final String TYPEKEY="type";

    private RelativeLayout loding_ly;
    private EditText loging_edit;
    private Button loging_btn;

    private RelativeLayout regit_ly;
    private EditText regit_lockkey_et;
    private EditText regit_lockkey_again_et;
    private Button regit_btn;
    private int cunnentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cunnentType=getIntent().getIntExtra(TYPEKEY,DEFART_TYPR);

        findView();
        initData();
    }

    private void findView() {
        loding_ly=(RelativeLayout)findViewById(R.id.loding_ly);
        loging_edit = (EditText) findViewById(R.id.loging_edit);
        loging_btn = (Button) findViewById(R.id.loging_btn);

        regit_ly=(RelativeLayout)findViewById(R.id.regit_ly);
        regit_lockkey_et = (EditText) findViewById(R.id.regit_lockkey_et);
        regit_lockkey_again_et = (EditText) findViewById(R.id.regit_lockkey_again_et);
        regit_btn=(Button)findViewById(R.id.regit_btn);
        loging_btn.setOnClickListener(this);
        regit_btn.setOnClickListener(this);
        loging_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int length=loging_edit.getText().length();
                if(length>0){
                    loging_btn.setEnabled(true);
                }else{
                    loging_btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void initData(){
        long lockpassword= Utils.getlongFromSharepreference(MainActivity.this,Utils.UNLOCK_KEY);
        if(lockpassword==-1){
            regit_ly.setVisibility(View.VISIBLE);
            loding_ly.setVisibility(View.GONE);
        }



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regit_btn:
                String lockStr= regit_lockkey_et.getText().toString();
                String lockagainStr= regit_lockkey_again_et.getText().toString();
                if(lockStr.length()>0&&lockagainStr.length()>0&&lockStr.equals(lockagainStr)){
                    Utils.putValueFromShareprefrence(this,Utils.UNLOCK_KEY,Long.valueOf(lockagainStr));
                    startIntentToActivity();
                }
                break;
            case R.id.loging_btn:
                if(loging_edit.getText()==null) return;
                long pasddword= Long.valueOf(loging_edit.getText().toString());
                long lockpassword= Utils.getlongFromSharepreference(MainActivity.this,Utils.UNLOCK_KEY);
                if(lockpassword==pasddword){
                    startIntentToActivity();
                }else{//TODO 用snackbar提示错误
                    Toast.makeText(this,"密码错误请重试",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void startIntentToActivity(){
        if(cunnentType==DEFART_TYPR){
            Intent intent=new Intent(MainActivity.this,ShowKeyActivity.class);
            startActivity(intent);
            finish();
        }else if(cunnentType==ADDKEY_TYPR){
            Intent intent=new Intent(MainActivity.this,AddKeyValueActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
