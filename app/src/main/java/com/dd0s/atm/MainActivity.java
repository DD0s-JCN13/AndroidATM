package com.dd0s.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int RC_LOGIN = 1;
    boolean login = false;
    List<String> fruits = Arrays.asList("西瓜","香蕉","鳳梨");

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
        RecyclerView recyclerview = findViewById(R.id.recycler);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new FruitAdapter());
    }
    private void listView(){
        ArrayAdapter<String> Adapter  = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(Adapter);
    }

    private class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull FruitAdapter.FruitViewHolder fruitViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        class FruitViewHolder extends RecyclerView.ViewHolder{
            TextView nameText;
            public FruitViewHolder(@NonNull View itemView) {
                super(itemView);
                nameText = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
