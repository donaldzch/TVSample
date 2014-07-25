package com.example.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.tv.model.UserInfo;
import com.example.android.tv.service.UserInfoService;


public class UserRegistrationActivity extends Activity {
    private EditText mUserName;
    private EditText mUserEmail;
    private EditText mUserPassword;
    private EditText mUserConfirmedPassword;
    private Button mConfirmBtn;
    private UserInfoService mUserService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        mUserName = (EditText)findViewById(R.id.register_name_text);
        mUserEmail = (EditText)findViewById(R.id.register_email_text);
        mUserPassword = (EditText)findViewById(R.id.register_password_text);
        mUserConfirmedPassword = (EditText)findViewById(R.id.register_password_reenter_text);
        mConfirmBtn = (Button)findViewById(R.id.register_confirm_btn);
        mUserService = UserInfoService.getInstance(this);

        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUserName.getText() == null || mUserName.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "INVALID USER NAME", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mUserEmail.getText() == null || mUserEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "INVALID USER EMAIL", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mUserPassword.getText() == null ||
                        mUserPassword.getText().toString().isEmpty() ||
                        mUserConfirmedPassword.getText() == null ||
                        !mUserConfirmedPassword.getText().equals(mUserPassword.getText())) {
                    Toast.makeText(getBaseContext(), "INVALID USER PASSWORD", Toast.LENGTH_SHORT).show();
                    return;
                }
                UserInfo newUser = new UserInfo();
                newUser.setUserName(mUserName.getText().toString());
                newUser.setUserPassword(mUserPassword.getText().toString());
                newUser.setUserPoints(5000L);
                newUser.setUserIcon("game_1");
                startTVActivity(mUserService.register(newUser));
            }
        });
    }

    private void startTVActivity(UserInfo newUser) {
        Intent intent = new Intent(this, TVActivity.class);
        intent.putExtra(Constants.CURRENT_USER_KEY, newUser);
        startActivity(intent);
    }
}