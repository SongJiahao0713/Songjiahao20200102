package com.bawei.songjiahao.songjiahao.model;

import com.bawei.songjiahao.songjiahao.contract.INewsContract;
import com.bawei.songjiahao.songjiahao.model.entity.ShopEntity;
import com.bawei.songjiahao.songjiahao.utils.OkHttpUtils;
import com.google.gson.Gson;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
public class Model implements INewsContract.IModel {
    @Override
    public void getShop(String url, ModelCallBack modelCallBack) {
        OkHttpUtils.getInstance().doGet(url, new OkHttpUtils.OkHttpCallBack() {
            @Override
            public void success(String s) {
                ShopEntity shopEntity = new Gson().fromJson(s, ShopEntity.class);
                modelCallBack.success(shopEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                modelCallBack.failure(throwable);
            }
        });
    }
}
