package com.dd0s.androidatm_ii;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class GenderActivity extends AppCompatActivity {

    EditText edGender;
    RecyclerView rvGender;
    String[] Gender = {"男性","女性","不公開"};
    boolean Recheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findview();
        listview();
    }
    public void findview(){
        edGender = findViewById(R.id.ed_Gender);
        rvGender = findViewById(R.id.recycler_Gender);
    }
    public void listview(){
        rvGender.hasFixedSize();
        rvGender.setLayoutManager(new LinearLayoutManager(this));
        rvGender.setAdapter(new GenderAdapter());
    }
    public void next(View v){
        String Gender = edGender.getText().toString();
        if(Gender.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("性別欄位不可為空白！")
                    .setPositiveButton("OK",null)
                    .show();
        }else if(Gender.equals("不公開")){
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("您可以在資料創建後再次修改資料，但性別僅能修改一次，敬請注意")
                    .setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Recheck = true;
                        }
                    })
                    .setNegativeButton("取消",null)
                    .show();
            if(Recheck){
                getSharedPreferences("atm",MODE_PRIVATE)
                        .edit()
                        .putString("Gender",Gender)
                        .apply();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void back(View v){finish();}
    class GenderAdapter extends RecyclerView.Adapter<GenderAdapter.GenderHolder>{

        @NonNull
        @Override
        public GenderAdapter.GenderHolder onCreateViewHolder(@NonNull ViewGroup familyGender, int i) {
            return new GenderHolder(getLayoutInflater().inflate(R.layout.gender_role,familyGender,false));
        }

        @Override
        public void onBindViewHolder(final @NonNull GenderHolder Holder, final int i) {
            Holder.list_Gender.setText(Gender[i]+" ");
            Holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("GenderActivity",Gender[i]+" chose");
                    edGender.setText(Gender[i]);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Gender.length;
        }

        class GenderHolder extends RecyclerView.ViewHolder{
            TextView list_Gender;
            public GenderHolder(@NonNull View itemView) {
                super(itemView);
                list_Gender = findViewById(R.id.listgender);
            }
        }
    }
}
