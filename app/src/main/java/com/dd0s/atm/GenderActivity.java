package com.dd0s.atm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next(View v){
        EditText edgender = findViewById(R.id.ed_Gender);
        String gender = edgender.getText().toString();
        if(gender.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("性別不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("gender",gender)
                    .apply();
            Intent main = new Intent (this, MainActivity.class);
            main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(main);

        }

    }
    public void back(View v){
        finish();
    }
}
