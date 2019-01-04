package com.dd0s.androidatm_ii;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

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
        ageList.setAdapter(new AgeAdapter());
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeAdapter.AgeHolder onCreateViewHolder(@NonNull ViewGroup family, int i) {
            return new AgeHolder(getLayoutInflater().inflate(R.layout.age_role,family,false));
        }

        @Override
        public void onBindViewHolder(@NonNull final AgeHolder Holder, final int i) {
            Holder.list_age.setText(age[i]+"");
            Holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("AgeActivity","onClick"+age[i]);
                    int clicked = Integer.parseInt(Holder.list_age.getText().toString());
                    edAge.setText(String.valueOf(clicked));
                }
            });
        }
        @Override
        public int getItemCount() {
            return age.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder {
            TextView list_age;
            public AgeHolder(@NonNull View itemView) {
                super(itemView);
                list_age = itemView.findViewById(R.id.listAge);
            }
        }
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
