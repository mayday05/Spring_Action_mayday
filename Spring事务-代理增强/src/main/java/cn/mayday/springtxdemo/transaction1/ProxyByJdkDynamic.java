package cn.mayday.springtxdemo.transaction1;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/3/31 12:14
 * @version: 1.0
 */
//代理类，也要实现相同的接口
public class ProxyByJdkDynamic implements TxService {

    //包含目标对象
    private TxService target;

    public ProxyByJdkDynamic(TxService target) {
        this.target = target;
    }

    //目标类中此方法带注解，进行特殊处理
    @Override
    public void doNeedTx() {
        //开启事务
        System.out.println("-> create Tx here in Proxy");
        //调用目标对象的方法，该方法已在事务中了
        target.doNeedTx();
        //提交事务
        System.out.println("<- commit Tx here in Proxy");
    }

    //目标类中此方法没有注解，只做简单的调用
    @Override
    public void doNotneedTx() {
        //直接调用目标对象方法
        target.doNotneedTx();
    }
}