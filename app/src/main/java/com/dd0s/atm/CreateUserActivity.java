package com.dd0s.atm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }
    public void next(View v){
        TextView ednickname = findViewById(R.id.ed_Nickname);
        String nickname = ednickname.getText().toString();
        if(nickname.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("暱稱不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("nickname",nickname)
                    .apply();
            Intent intent = new Intent(this,AgeActivity.class);
            startActivity(intent);
        }
    }
    public void back(View v){
        finish();
    }
}
