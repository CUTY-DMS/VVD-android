package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.login.databinding.ActivityMainBinding;
import com.example.login.databinding.FragmentAddBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add extends Fragment {

    private FragmentAddBinding binding;

    private String Token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("add", "onClick");
                attemptJoin();
            }
        });
        return view;
    }

    private void attemptJoin() {
        Log.d("add", "attemptJoin");
        String title = binding.title.getText().toString();
        String content = binding.content.getText().toString();

        ContentData contentData = new ContentData(title,content);

        Token = MainActivity.token;
        AddApi addApi = ApiProvider.getInstance().create(AddApi.class);

        addApi.usercontent(Token, contentData).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    binding.title.setText(" ");
                    binding.content.setText(" ");
                    Toast.makeText(getActivity(), "글쓰기 성공", Toast.LENGTH_SHORT).show();
                }else if (response.code() == 401) {
                    Log.e("TAG","response");
                    Toast.makeText(getActivity(), Token, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity(), "실패", Toast.LENGTH_SHORT).show();
            }
        });

//        Call<ContentData> call = postApi.usercontent(MainActivity.token,contentData);
//        call.enqueue(new Callback<ContentData>() {
//            @Override
//            public void onResponse(Call<ContentData> call, Response<ContentData> response) {
//                if (response.isSuccessful()){
//                    binding.title.setText(" ");
//                    binding.content.setText(" ");
//                }else if (response.code() == 401){
//                    Toast.makeText(getActivity(),"김은오바보",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getActivity(),"실패!",Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<ContentData> call, Throwable t) {
//                Toast.makeText(getActivity(),"다시시도",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}