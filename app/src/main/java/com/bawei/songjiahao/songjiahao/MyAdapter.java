package com.bawei.songjiahao.songjiahao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjiahao.model.entity.ShopEntity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context context;
    private final List<ShopEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList;

    public MyAdapter(Context context, List<ShopEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(commodityList.get(position).getMasterPic())
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.iv);
        holder.tv.setText(commodityList.get(position).getCommodityName());
        holder.tv1.setText("$"+commodityList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        TextView tv1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
