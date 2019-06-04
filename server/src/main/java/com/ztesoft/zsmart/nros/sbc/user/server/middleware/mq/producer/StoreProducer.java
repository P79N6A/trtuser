package com.ztesoft.zsmart.nros.sbc.user.server.middleware.mq.producer;

import com.aliyun.openservices.ons.api.Producer;
import com.ztesoft.zsmart.nros.base.zmq.entity.NrosMQMessage;
import com.ztesoft.zsmart.nros.base.zmq.producer.DefaultZMQProducer;
import com.ztesoft.zsmart.nros.sbc.user.server.middleware.mq.model.StoreMq;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 门店生产者
 * @author bin.yu
 * @create 2019-04-20 10:48
 **/
@Component
public class StoreProducer {

    private static final Logger logger = LoggerFactory.getLogger(StoreProducer.class);

    @Value("${zmq.produce.user.topic}")
    private String item_topic;
    @Value("${zmq.posGroupId}")
    private String posGroupId;
    @Value("${zmq.ecGroupId}")
    private String ecGroupId;
    @Value("${zmq.cyGroupId}")
    private String cyGroupId;

    @Autowired
    private DefaultZMQProducer producer;



    public <T> T sendMsg(StoreMq body) {
        Producer aliPosProducer = producer.getAliProducer(posGroupId);
        Producer aliEcProducer = producer.getAliProducer(ecGroupId);
        Producer aliCyProducer = producer.getAliProducer(cyGroupId);

        JSONObject msgBody = new JSONObject();
        msgBody.put("contentStatus", "");
        msgBody.put("contentType", "STORE_SYNC");
        msgBody.put("content", "门店数据同步");
        msgBody.put("data", body);
        NrosMQMessage msg = NrosMQMessage.buildNrosMQMessage(msgBody, item_topic);
        try {
            producer.sendMessage(aliEcProducer, msg);
            producer.sendMessage(aliPosProducer, msg);
//            producer.sendMessage(aliCyProducer, msg);
        }
        catch (Exception e) {
            logger.error("门店消息发送失败", e);
        }
        return null;
    }
}
