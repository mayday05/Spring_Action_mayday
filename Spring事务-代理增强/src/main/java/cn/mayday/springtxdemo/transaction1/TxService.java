package cn.mayday.springtxdemo.transaction1;

import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/3/31 13:00
 * @version: 1.0
 */
@Service
public interface TxService {
    void doNeedTx();

    void doNotneedTx();
}
