package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter2 extends RecyclerView.Adapter<listAdapter2.CustomViewHorder>{

    private ArrayList<TodoDetailRespons> arrayList;
    public listAdapter2(ArrayList<TodoDetailRespons> arrayList){this.arrayList = arrayList;}

    @NonNull
    @Override
    public listAdapter2.CustomViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2,parent,false);
        listAdapter2.CustomViewHorder holder = new listAdapter2.CustomViewHorder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter2.CustomViewHorder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.date.setText(String.valueOf(arrayList.get(position).getDateTime()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class CustomViewHorder extends RecyclerView.ViewHolder {
        protected TextView title;
        //protected ImageView liked;
        protected TextView date;
        public CustomViewHorder(@NonNull View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.Title);
            //this.liked = (ImageView) itemView.findViewById(R.id.liked);
            this.date = (TextView) itemView.findViewById(R.id.datetime);
        }
    }

}
