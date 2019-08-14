package com.cashsystem.service;

import com.cashsystem.dao.GoodsDao;
import com.cashsystem.entity.Goods;

import java.util.List;

/**
 * @className GoodsService
 * @Description TODO
 * @Author f
 * @Date 2019/8/6 15:45
 * @Version 1.0
 **/
public class GoodsService {
    public GoodsDao goodsDao;
    public GoodsService(){
        this.goodsDao = new GoodsDao();
    }

    public List<Goods> quarryAllGoods(){
        return this.goodsDao.quarryAllGoods();
    }
    //上架商品
    public boolean putAwayGoods(Goods goods){
        return this.goodsDao.putAwayGoods(goods);
    }
    public Goods getGoods(int goodId){
        return this.goodsDao.getGoods(goodId);
    }
    public boolean modifyGoods(Goods goods){
        return this.goodsDao.modifyGoods(goods);
    }
    public boolean deleteGoods(int goodsId){
        return this.goodsDao.deleteGoods(goodsId);
    }
    public boolean updateAfterPay(Goods goods,int getBuyGoodsNum){
        return this.goodsDao.updateAfterPay(goods,getBuyGoodsNum);
    }
}
