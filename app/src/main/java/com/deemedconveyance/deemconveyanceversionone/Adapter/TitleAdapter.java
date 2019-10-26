package com.deemedconveyance.deemconveyanceversionone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.deemedconveyance.deemconveyanceversionone.Activity.ViewContent;
import com.deemedconveyance.deemconveyanceversionone.Model.Titile;
import com.deemedconveyance.deemconveyanceversionone.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder>
{
    Context mContext;
    List<Titile> mData;

    public TitleAdapter(Context mContext, List<Titile> mData)
    {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.title_list,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
//        Toast.makeText(mContext,viewType,Toast.LENGTH_SHORT).show();
//        Toast.makeText(mContext, (CharSequence) parent,Toast.LENGTH_SHORT).show();
        vHolder.item_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(mContext,"Test Clicked"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                String item = String.valueOf(vHolder.getAdapterPosition());
                Intent intent = new Intent(mContext, ViewContent.class);
                intent.putExtra("item", item);
                mContext.startActivity(intent);
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.title_id.setText(mData.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private LinearLayout item_list;
        private TextView title_id;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            item_list = (LinearLayout) itemView.findViewById(R.id.item_list);
            title_id = (TextView) itemView.findViewById(R.id.title_id);
        }
    }
}
