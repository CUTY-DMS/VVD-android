
package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.CustomViewHorder>{

    private ArrayList<listData> arrayList;
    public listAdapter(ArrayList<listData> arrayList){this.arrayList = arrayList;}

    @NonNull
    @Override
    public listAdapter.CustomViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHorder holder = new CustomViewHorder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull listAdapter.CustomViewHorder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.name.setText(arrayList.get(position).getName());
        //holder.dateTime.setText(arrayList.get(position).getDateTime());
        //holder.content.setClickable(arrayList.get(position).isCompleted());
        //holder.likes.setImageResource(arrayList.get(position).isLiked());

        holder.itemView.setTag(position);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewHorder extends RecyclerView.ViewHolder {
        protected TextView title;
        //public TextView dateTime;
        protected TextView content;
        protected TextView name;
        //public CheckBox completed;
        //public ImageView likes;
        public CustomViewHorder(@NonNull View itemView) {
            super(itemView);
        }

        public CustomViewHorder(@NonNull View itemView, TextView name, TextView title,TextView content) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            //this.dateTime = (TextView) itemView.findViewById(R.id.date);
            this.content = (TextView) itemView.findViewById(R.id.content);
            this.name = (TextView) itemView.findViewById(R.id.name);
            //this.likes = (ImageView) itemView.findViewById(R.id.likes);
            //this.completed = (CheckBox) itemView.findViewById(R.id.completed);
        }
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
