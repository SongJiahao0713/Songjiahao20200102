package com.bawei.songjiahao.songjiahao.base;

import com.bawei.songjiahao.songjiahao.contract.INewsContract;

import java.lang.ref.WeakReference;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
public abstract class BasePresenter<M extends BaseModel,V extends BaseView> implements INewsContract.IPresenter {
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }

    protected abstract M initModel();

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    public V getView(){
        return weakReference.get();
    }

    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
}
