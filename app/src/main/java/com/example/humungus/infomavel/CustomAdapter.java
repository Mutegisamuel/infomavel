package com.example.humungus.infomavel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by humungus on 2/1/18.
 */

public class CustomAdapter extends BaseAdapter {

    private List<Response.DataBean.ResultsBean> mCharacteritem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext,List<Response.DataBean.ResultsBean> mCharacteritem) {
        this.mContext = mContext;
        this.mCharacteritem = mCharacteritem;

    }

    @Override
    public int getCount() {
        return mCharacteritem.size();
    }

    @Override
    public Object getItem(int position) {
        return mCharacteritem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext
                .getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item,parent,false);
        Response.DataBean.ResultsBean item = (Response.DataBean.ResultsBean) getItem(position);
        ImageView thumbnail = rowView.findViewById(R.id.thubnail);
        TextView tittle= rowView.findViewById(R.id.tittle);
        TextView description = rowView.findViewById(R.id.description);
        String imgUrl = item.getThumbnail().getPath()+ "/landscape_xlarge.jpg";
        Log.v("image" , imgUrl);

        Picasso.with(mContext).load(imgUrl).into(thumbnail);

        tittle.setText(item.getName());
        description.setText(item.getDescription());

        return rowView;
    }
}
