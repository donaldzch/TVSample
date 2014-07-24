package com.example.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.tv.service.UserInfoService;

public class UserLoginActivity extends Activity {
    private EditText mUserName;
    private EditText mUserPassword;
    private Button mLoginBtn;
    private Button mRegisterBtn;
    private UserInfoService mUserService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        mUserName = (EditText)findViewById(R.id.user_name_text);
        mUserPassword = (EditText)findViewById(R.id.user_password_text);

        mLoginBtn = (Button)findViewById(R.id.login_btn);

        mRegisterBtn = (Button)findViewById(R.id.close_btn);

        mUserService = UserInfoService.getInstance(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mUserService.login(mUserName.getText().toString(), mUserPassword.getText().toString())) {
                    Toast.makeText(getParent(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getParent(), TVActivity.class);
                    intent.putExtra(Constants.CURRENT_USER_KEY, mUserService.getCurrentUser());
                    startActivity(intent);
                }
            }
        });
    }
}