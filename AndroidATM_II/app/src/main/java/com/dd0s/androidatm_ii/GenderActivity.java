package com.dd0s.androidatm_ii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GenderActivity extends AppCompatActivity {

    EditText edGender;
    RecyclerView rvGender;
    TextView Genderrole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findview();
    }
    public void findview(){
        edGender = findViewById(R.id.ed_Gender);
        rvGender = findViewById(R.id.recycler_Gender);
        Genderrole = findViewById(R.id.gender_role);
    }
    public void next(View v){

    }
}
