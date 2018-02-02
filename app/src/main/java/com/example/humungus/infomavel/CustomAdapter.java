package com.example.humungus.infomavel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by humungus on 2/1/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private List<Response.DataBean.ResultsBean> listItems;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext,List<Response.DataBean.ResultsBean> listItems) {
        this.mContext = mContext;
        this.listItems = listItems;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_list_item,parent ,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position ) {
        Response.DataBean.ResultsBean listItem = listItems.get(position);
        String imageUrl = listItem.getThumbnail().getPath()+"/landscape_incredible.jpg";
        Picasso.with(mContext).load(imageUrl).into(holder.thumbnail);
        holder.tittle.setText((CharSequence) listItem.getName());
        holder.description.setText(listItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        public TextView tittle;
        public TextView description;

        public ViewHolder(View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            tittle = (TextView) itemView.findViewById(R.id.tittle);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }




}






