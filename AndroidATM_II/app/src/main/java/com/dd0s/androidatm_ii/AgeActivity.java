package com.dd0s.androidatm_ii;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    EditText edAge;
    RecyclerView ageList;
    int age[]={19,20,21,22,23,24,25,26,27,28,29,30};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findview();
        listview();
    }
    public void findview(){
        edAge = findViewById(R.id.ed_Age);
        ageList = findViewById(R.id.recycler);
    }
    public void listview(){
        ageList.setHasFixedSize(true);
        ageList.setLayoutManager(new LinearLayoutManager(this));
        ageList.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
    }
    public void next(View v){
        String age = edAge.getText().toString();
        if(age.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("年齡欄位不可為空白！")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            int ageint = Integer.parseInt(age);
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putInt("AGE",ageint)
                    .apply();
            Intent intent = new Intent(this, GenderActivity.class);
            startActivity(intent);
        }
    }
    public void back(View v){finish();}



    }
