package com.example.login;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.databinding.ActivitySignupBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup<postApi> extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private PostApi postApi;
    private String Password;
    private int Age;
    private String Name;
    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptJoin();
            }
        });
    }

    private void attemptJoin() {
        Name = binding.mName.getText().toString();
        Id = binding.mId.getText().toString();
        Password = binding.mPassword.getText().toString();
        Age = Integer.parseInt(binding.mAge.getText().toString());

        signupData signupData = new signupData(Id, Password,Name ,Age);

        postApi = ApiProvider.getInstance().create(PostApi.class);

        try {
            startJoin(new signupData(Id, Password, Name, Age));
        } catch (Throwable e) {
            Toast.makeText(this, "asdas", Toast.LENGTH_SHORT).show();
        }
    }
    private void startJoin(signupData data) {
        postApi.usersignup(data).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.e("TAG","onResponse");
                if (response.code() == 404) {
                    Toast.makeText(getApplicationContext(), "user not found!", Toast.LENGTH_SHORT).show();
                }else if (response.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(signup.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}