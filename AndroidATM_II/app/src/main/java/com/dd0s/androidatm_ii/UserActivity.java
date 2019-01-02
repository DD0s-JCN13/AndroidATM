package com.dd0s.androidatm_ii;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    EditText edUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        findview();
    }
    public void findview(){
        edUsername = findViewById(R.id.ed_Username);
    }
    public void next(View v){
        String Username = edUsername.getText().toString();
        if(Username.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("使用者名稱不可為空白！")
                    .setPositiveButton("確定",null)
                    .show();
        }else{
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERNAME",Username)
                    .apply();
            Intent intent = new Intent(this,AgeActivity.class);
            startActivity(intent);
        }
    }
}
