package app;


/**
 * Desc: 业务数据动态分流
 * 需要启动的进程
 *      zk、kafka、maxwell、hdfs、hbase、BaseDBApp
 * 执行流程
 *      -基本环境准备
 *      -检查点设置
 *      -读取主流中业务数据
 *      -对读取的数据进行类型转换
 *      -对主流业务数据进行ETL
 *
 *      -使用FlinkCDC读取配置表中的数据，得到配置流
 *      -将配置流进行广播，并创建广播状态
 *      -使用connect算子将主流和配置流进行连接
 *      -对连接之后的流进行分流处理  ---维度数据：维度侧输出流中     事实数据：主流
 *
 *      -抽取TableProcessFunction类处理分流业务
 *          >processElement
 *              4.字段过滤
 *              2.从状态中获取当前处理的业务数据对应的配置信息，根据配置信息进行分流
 *          >processBroadcastElement
 *              1.从广播流中读取配置信息封装为TableProcess对象，并放到广播状态中
 *              3.如果当前读到的配置信息是维度配置的话，提前创建维度表
 *                  -抽取专门建表的方法 checkTable
 *                  -拼接建表语句
 *                  -通过jdbc方式 执行建表语句
 *
 *
 */
public class BaseDBApp {


}
