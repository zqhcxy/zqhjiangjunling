package com.jiangjunling.zqh.zqhjiangjunling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jiangjunling.zqh.zqhjiangjunling.util.Utils;

/**
 * 保存key，如果key之前存在，就会被覆盖
 */
public class AddKeyValueActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mValueEditText;
    private Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_key_value);

        initView();
    }

    private void initView() {

        mNameEditText = (EditText) findViewById(R.id.addkey_keyname_ed);
        mValueEditText = (EditText) findViewById(R.id.addkey_keyvalue_ed);
        mConfirmButton = (Button) findViewById(R.id.addkey_confirm_btn);

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String value = mValueEditText.getText().toString();
                String toasttext;
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
                    Utils.putValueFromShareprefrence(getApplicationContext(), name, value);
                    mNameEditText.setText("");
                    mValueEditText.setText("");
                    toasttext=getResources().getString(R.string.addkey_success_input_text);
                } else {
                     toasttext = getResources().getString(R.string.addkey_faile_input_text);
                }
                Toast.makeText(getApplicationContext(), toasttext, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
