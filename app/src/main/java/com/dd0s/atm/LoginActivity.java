package com.dd0s.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edAccount;
    EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FindViews();
    }
    public void FindViews(){
        edAccount = findViewById(R.id.ed_Account);
        edPassword = findViewById(R.id.ed_Password);
    }

    public void login(View v){
        String Account = edAccount.getText().toString();
        String Password = edPassword.getText().toString();
        if(Account.equals("jcn13") && Password.equals("98765")){
            Toast.makeText(this, "Login Success!!",Toast.LENGTH_LONG).show();
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("ATM")
                    .setMessage("Login FAILED!!")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }

    public void cancel(View v){

    }
}
