package com.example.login;

import static com.example.login.R.layout.fragment_add;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button signup,login;
    private EditText id,password;
    private Retrofit retrofit;
    private PostApi postApi;
    public static String token;
    private Fragment add;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            password = (EditText) findViewById(R.id.password);
            login = (Button) findViewById(R.id.login);
            signup = (Button) findViewById(R.id.signUp);
            signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                password.setText("");
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });

        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        postApi = ApiProvider.getInstance().create(PostApi.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    attemptLogin();
            }
            private void attemptLogin() {
                String logId = id.getText().toString();
                String logPassword = password.getText().toString();
                loginData logindata = new loginData(logId,logPassword);
                try {
                    startLogin(new loginData(logId,logPassword));
                }catch (Throwable e){
                    Toast.makeText(getApplicationContext(),"nuj",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startLogin(loginData data) {
        postApi.userlogin(data).enqueue(new Callback<loginResponse>() {
            @SuppressLint("ResourceType")
            @Override
            public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                if (response.code() == 404) {
                    Toast.makeText(getApplicationContext(), "user not found!", Toast.LENGTH_SHORT).show();
                } else if (response.isSuccessful()){
                    token = response.body().getAccessToken();
                    Intent intent2 = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent2);
                }else{
                    Toast.makeText(MainActivity.this,"응 아니야",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<loginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}