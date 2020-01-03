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
 * 时间：2020/1/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class RxAdapter extends RecyclerView.Adapter<RxAdapter.MyViewHolder> {
    private final Context context;
    private final List<ShopEntity.ResultBean.RxxpBean.CommodityListBean> commodityList2;

    public RxAdapter(Context context, List<ShopEntity.ResultBean.RxxpBean.CommodityListBean> commodityList2) {
        this.context = context;
        this.commodityList2 = commodityList2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item1, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(commodityList2.get(position).getMasterPic())
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.riv);
        holder.rtv.setText(commodityList2.get(position).getCommodityName());
        holder.rtv1.setText("$"+commodityList2.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return commodityList2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView riv;
        TextView rtv;
        TextView rtv1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            riv=itemView.findViewById(R.id.riv);
            rtv=itemView.findViewById(R.id.rtv);
            rtv1=itemView.findViewById(R.id.rtv1);
        }
    }
}
