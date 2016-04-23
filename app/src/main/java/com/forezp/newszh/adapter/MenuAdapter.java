package com.forezp.newszh.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forezp.newszh.R;
import com.forezp.newszh.domain.MenuItem;
import com.trilink.androidlib.adapter.ArrayListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gejiahui on 2016/3/13.
 */
public class MenuAdapter extends ArrayListAdapter {

    private Context mContext;

    public MenuAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.menu_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
       MenuItem menuItem=(MenuItem) getList().get(position);
        holder.menuItemTitle.setText(menuItem.getTitle());
        holder.menuItemImg.setBackgroundResource(menuItem.getResId());
        if(menuItem.isSelected()){
            holder.menItem.setBackgroundResource(R.color.menu_selected);
        }else{
            holder.menItem.setBackgroundResource(R.color.white);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.menu_item_img)
        ImageView menuItemImg;
        @Bind(R.id.menu_item_title)
        TextView menuItemTitle;
        @Bind(R.id.men_item)
        LinearLayout menItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
