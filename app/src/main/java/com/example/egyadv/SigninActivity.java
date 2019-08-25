package com.example.egyadv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.egyadv.Model.LoginResponse;
import com.example.egyadv.Retrofitclient.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Email,Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Email=(EditText)findViewById(R.id.emailedittext);
        Password=(EditText)findViewById(R.id.passwordedittext);
        findViewById(R.id.loginbutton).setOnClickListener(this);

    }
    private void Userlogin(){
        String email=Email.getText().toString().trim();
        String password=Password.getText().toString().trim();
        if (email.isEmpty()){
            Email.setError("Enter your email");
            Email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            Password.setError("Enter your password");
            Password.requestFocus();
            return;
        }
        if (password.length()<6){
            Password.setError("password length should be more than 5 charachter");
            Password.requestFocus();
            return;
        }
        Call<LoginResponse>call= RetrofitClient.getInstance().getApi().LoginUser(email,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                if (loginResponse!=null){
                    Toast.makeText(SigninActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(SigninActivity.this, "", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loginbutton:
                Userlogin();
                break;

        }

    }
}
