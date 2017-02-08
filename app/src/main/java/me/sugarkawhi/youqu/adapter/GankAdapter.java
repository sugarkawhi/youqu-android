package me.sugarkawhi.youqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import me.sugarkawhi.youqu.R;
import me.sugarkawhi.youqu.bean.GankIoDataBean;

/**
 * 图片
 * Created by sugarkawhi on 2017/2/8.
 */

public class GankAdapter extends RecyclerView.Adapter<GankAdapter.GankHolder> {

    private Context context;
    private List<GankIoDataBean.ResultBean> mlist = new ArrayList<>();

    public GankAdapter(Context context) {
        this.context = context;
    }

    public void addAll(List<GankIoDataBean.ResultBean> list){
        mlist.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public GankAdapter.GankHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_gank, parent, false);
        return new GankHolder(view);
    }

    @Override
    public void onBindViewHolder(GankAdapter.GankHolder holder, int position) {
        Glide.with(context)
                .load(mlist.get(position).getUrl())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    protected static class GankHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public GankHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_pic);
        }
    }
}