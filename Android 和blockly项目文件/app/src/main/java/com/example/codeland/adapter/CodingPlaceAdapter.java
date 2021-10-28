package com.example.codeland.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.codeland.R;
import com.example.codeland.bmob.CodingPlace;

import java.util.List;

public class CodingPlaceAdapter extends ArrayAdapter<CodingPlace> {
    private int resourceId;
    public CodingPlaceAdapter(Context context, int textViewResourceId, List<CodingPlace> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CodingPlace codingplace=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.recordName=view.findViewById(R.id.record_name);
            viewHolder.recordDate=view.findViewById(R.id.record_date);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.recordName.setText(codingplace.getName());
        viewHolder.recordDate.setText(codingplace.getDate());
        return view;
    }

    class ViewHolder{
        TextView recordName;
        TextView recordDate;
    }
}
