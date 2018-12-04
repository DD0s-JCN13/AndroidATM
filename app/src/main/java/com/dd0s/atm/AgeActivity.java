package com.dd0s.atm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void next(View v){
        TextView edage = findViewById(R.id.ed_Age);
        String age = edage.getText().toString();
        if(age.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("年齡欄位不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            int ageint = Integer.parseInt(age);
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putInt("age",ageint)
                    .apply();
            Intent gender = new Intent(this,GenderActivity.class);
            startActivity(gender);
        }
    }

    public void back(View v){
        finish();
    }
}
