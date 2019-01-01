package com.dd0s.atm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class AgeActivity extends AppCompatActivity {

    int[] Age={19,20,21,22,23,24,25,26,27,28};
    private void listView(){
        RecyclerView agelist = findViewById(R.id.recycler);
        agelist.setHasFixedSize(true);
        agelist.setLayoutManager(new LinearLayoutManager(this));
        agelist.setAdapter(new AgeAdapter());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup family, int i) {
            return new AgeHolder(getLayoutInflater().inflate(R.layout.row_age,family,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder Holder, int i) {
            Holder.ageroler.setText(Age[i]+" ");
        }
        @Override
        public int getItemCount() {
            return Age.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder{
            TextView ageroler;
            public AgeHolder(View itemView){
                super(itemView);
                ageroler = itemView.findViewById(R.id.txt_AgeRole);
            }
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
