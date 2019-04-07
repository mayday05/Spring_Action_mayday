package cn.mayday.springtxdemo.transaction1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/3/31 11:59
 * @version: 1.0
 */
//目标类，实现接口
@Service
public class ServiceImpl implements TxService {

    @Transactional
    @Override
    public void doNeedTx() {
        System.out.println("execute doNeedTx in ServiceImpl");
    }

    //no annotation here
    @Override
    public void doNotneedTx() {
        this.doNeedTx();
    }
}