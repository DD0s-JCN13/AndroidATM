package com.dd0s.atm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class AgeActivity extends AppCompatActivity {

    List<Integer> Age = Arrays.asList(19,20,21,22,23);
    private void listView(){
        ArrayAdapter<Integer> AgeAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Age);
        ListView agelist = findViewById(R.id.Agelist);
        agelist.setAdapter(AgeAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    class AgeHolder extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeAdapter.AgeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull AgeAdapter.AgeHolder ageHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
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
