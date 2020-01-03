package com.bawei.songjiahao.songjiahao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.songjiahao.songjiahao.base.BaseActivity;
import com.bawei.songjiahao.songjiahao.contract.INewsContract;
import com.bawei.songjiahao.songjiahao.model.entity.ShopEntity;
import com.bawei.songjiahao.songjiahao.presenter.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity<Presenter> implements INewsContract.IView {

    private RecyclerView rv;
    private RecyclerView rv1;
    private RecyclerView rv2;

    @Override
    protected void initData() {
        presenter.getShop("http://172.17.8.100/small/commodity/v1/commodityList");
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rv1 = findViewById(R.id.rv1);
        rv1.setLayoutManager(new GridLayoutManager(this,2));
        rv2 = findViewById(R.id.rv2);
        rv2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    public void success(ShopEntity shopEntity) {
        List<ShopEntity.ResultBean.RxxpBean.CommodityListBean> commodityList2 = shopEntity.getResult().getRxxp().getCommodityList();
        RxAdapter rxAdapter = new RxAdapter(this, commodityList2);
        rv2.setAdapter(rxAdapter);
        List<ShopEntity.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = shopEntity.getResult().getPzsh().getCommodityList();
        ShopAdapter shopAdapter = new ShopAdapter(this, commodityList1);
        rv1.setAdapter(shopAdapter);
        List<ShopEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList = shopEntity.getResult().getMlss().getCommodityList();
        MyAdapter myAdapter = new MyAdapter(this,commodityList);
        rv.setAdapter(myAdapter);
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
