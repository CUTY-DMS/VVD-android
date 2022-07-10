package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.databinding.ActivityMainBinding;

import org.json.JSONObject;

import java.lang.reflect.Member;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button signup,login;
    private EditText id,password;
    private Retrofit retrofit;
    private PostApi postApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = (Button) findViewById(R.id.signUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                try {
                    startLogin(new loginData(logId,logPassword));
                }catch (Throwable e){
                    Toast.makeText(getApplicationContext(),"nuj",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void startLogin(loginData data) {
        postApi.userlogin(data).enqueue(new Callback<loginRequest>() {
            @Override
            public void onResponse(Call<loginRequest> call, Response<loginRequest> response) {
                if (response.isSuccessful()) {
                    loginRequest request = response.body();
                    Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                    finish();
                } else if (response.code() == 404) {
                    Toast.makeText(getApplicationContext(), "user not found!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<loginRequest> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}