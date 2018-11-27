package com.dd0s.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int RC_LOGIN = 1;
    boolean login = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK){
                finish();
            }else{
                login = true;
                String nickname = getSharedPreferences("atm",MODE_PRIVATE)
                        .getString("nickname",null);
                int age = getSharedPreferences("atm",MODE_PRIVATE)
                        .getInt("age",0);
                String gender = getSharedPreferences("atm",MODE_PRIVATE)
                        .getString("gender",null);
                if(nickname.equals(null) || age==0 || gender.equals(null)){
                    Intent redo = new Intent(this,CreateUserActivity.class);
                    startActivity(redo);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }


    }
}
