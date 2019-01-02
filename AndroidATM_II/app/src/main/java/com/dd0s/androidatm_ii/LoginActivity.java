package com.dd0s.androidatm_ii;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUserid;
    EditText edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findview();
    }
    public void findview(){
        edUserid = findViewById(R.id.ed_Userid);
        edPassword = findViewById(R.id.ed_Password);
    }
    public void login(View v){
        String Userid = edUserid.getText().toString();
        String Password = edPassword.getText().toString();
        if(Userid.equals("jacky")&&Password.equals("123456")){
            Toast.makeText(this,"登入成功！",Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_ACCOUNT",Userid);
            getIntent().putExtra("LOGIN_PASSWORD",Password);
            setResult(RESULT_OK,getIntent());
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USER",Userid)
                    .apply();
            Intent intent = new Intent(this,UserActivity.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("帳號或密碼輸入錯誤，請重新輸入！")
                    .setPositiveButton("確定",null)
                    .show();
        }
    }
    public void clean(View v){
        edUserid.setText("");
        edPassword.setText("");
    }
}
