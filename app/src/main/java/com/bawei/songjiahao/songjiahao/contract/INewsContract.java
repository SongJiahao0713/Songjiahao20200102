package com.bawei.songjiahao.songjiahao.contract;

import com.bawei.songjiahao.songjiahao.base.BaseModel;
import com.bawei.songjiahao.songjiahao.base.BaseView;
import com.bawei.songjiahao.songjiahao.model.entity.ShopEntity;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
public interface INewsContract {
    interface IModel extends BaseModel{
        interface ModelCallBack{
            void success(ShopEntity shopEntity);
            void failure(Throwable throwable);

        }
        void getShop(String url, ModelCallBack modelCallBack);
    }
    interface IView extends BaseView{
        void success(ShopEntity shopEntity);
        void failure(Throwable throwable);
    }

    interface IPresenter{
        void getShop(String url);
    }
}
