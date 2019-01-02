package com.dd0s.androidatm_ii;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final int RC_LOGIN=1;
    boolean login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RC_LOGIN){
            if(resultCode != RESULT_OK){
                finish();
            }else{
                login = true;
                String nickname = getSharedPreferences("atm", MODE_PRIVATE)
                        .getString("nickname",null);
            }
        }
    }
}
