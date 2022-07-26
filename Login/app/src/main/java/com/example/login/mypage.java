
package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.databinding.FragmentMypageBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mypage extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<listData> list;
    private LinearLayoutManager linearLayoutManager;
    private listAdapter listAdapter;
    private TextView name, age;
    private PostApi postApi;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);
        name = (TextView) rootView.findViewById(R.id.name);
        age = (TextView) rootView.findViewById(R.id.age);
        postApi = ApiProvider.getInstance().create(PostApi.class);

        postApi.userTodo(MainActivity.token).enqueue(new Callback<mypageData>() {
            @Override
            public void onResponse(Call<mypageData> call, Response<mypageData> response) {
                name.setText(response.body().getName());
                age.setText(""+response.body().getAge());
                list = new ArrayList<>();
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                listAdapter = new listAdapter(list);
                recyclerView.setAdapter(listAdapter);
            }
            @Override
            public void onFailure(Call<mypageData> call, Throwable t) {
                Toast.makeText(getActivity(), "실패", Toast.LENGTH_SHORT).show();
            }
        });
    return rootView;
    }
}