package com.example.absen_kelas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.absen_kelas.api_client.ApiClient;
import com.example.absen_kelas.request.UserRequest;
import com.example.absen_kelas.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

        private EditText inputEmail, inputPassword;
        private ProgressBar progressBar;
        private Button btnLogin, btnSignup, btnReset;
        //private ImageButton btnLogin;

        @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            inputEmail = findViewById(R.id.emailEt);
            inputPassword = findViewById(R.id.passwordEt);
            btnLogin = findViewById(R.id.loginBtn);
            
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Loginbtn();
                }
            });
    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void daftarBtn(View view) {
        Intent intent = new Intent(login.this,signup.class);
        startActivity(intent);
    }

    public void Loginbtn() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(inputEmail.getText().toString());
        userRequest.setPassword(inputPassword.getText().toString());

        Call<UserResponse> userResponseCall = ApiClient.getUserService().login(userRequest);

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    UserResponse userResponse = response.body();
                    Toast.makeText(login.this, "Login berhasil, "+userResponse.getEmail(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("eror", t.getLocalizedMessage());
                Toast.makeText(login.this, "cok gak lkenek, "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}