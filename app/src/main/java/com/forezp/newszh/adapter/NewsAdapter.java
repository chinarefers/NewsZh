package com.forezp.newszh.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.forezp.newszh.R;
import com.forezp.newszh.model.bean.News;
import com.trilink.androidlib.adapter.ArrayListAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by b508a on 2016/4/12.
 */
public class NewsAdapter extends ArrayListAdapter {



    private Context mContext;

    public NewsAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        News news=(News)getList().get(position);
        holder.tvTitle.setText(news.getTitle());
        holder.tvContent.setText(news.getSummary());
        holder.tvNum.setText(news.getVote());
        Uri uri=Uri.parse(news.getAvatar());
        holder.userAvator.setImageURI(uri);
        return convertView;
    }



    class ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.user_avator)
        SimpleDraweeView userAvator;
        @Bind(R.id.tv_num)
        TextView tvNum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
