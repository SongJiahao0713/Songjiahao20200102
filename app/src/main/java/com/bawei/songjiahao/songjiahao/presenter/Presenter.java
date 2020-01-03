package com.bawei.songjiahao.songjiahao.presenter;

import com.bawei.songjiahao.songjiahao.base.BaseModel;
import com.bawei.songjiahao.songjiahao.base.BasePresenter;
import com.bawei.songjiahao.songjiahao.contract.INewsContract;
import com.bawei.songjiahao.songjiahao.model.Model;
import com.bawei.songjiahao.songjiahao.model.entity.ShopEntity;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
public class Presenter extends BasePresenter<Model,INewsContract.IView> implements INewsContract.IPresenter {


    @Override
    public void getShop(String url) {
        model.getShop(url, new INewsContract.IModel.ModelCallBack() {
            @Override
            public void success(ShopEntity shopEntity) {
                getView().success(shopEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }

    @Override
    protected Model initModel() {
        return new Model();
    }
}
