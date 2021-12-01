package rudolfisky.demotica_dashboardtemperature_service.configurations;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import rudolfisky.demotica_dashboardtemperature_service.resources.TempDB;
import rudolfisky.demotica_dashboardtemperature_service.services.TempService;

import javax.persistence.Convert;

@Configuration
public class MqttBeans {

    @Autowired
    private TempService service;

//    public MqttPahoClientFactory mqttpahoClientFactory(){
//        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
//        MqttConnectOptions options = new MqttConnectOptions();
//
//        options.setServerURIs(new String[] {"tcp://192.168.0.70:1883"});
//        options.setUserName("admin");
//        options.setUserName("admin");
//        String pass = "1234";
//        options.setPassword(pass.toCharArray());
//        options.setCleanSession(true);
//
//        factory.setConnectionOptions(options);
//        return factory;
//    }
//
//    @Bean
//    public MessageChannel mqttInputChannel(){
//        return new DirectChannel();
//    }
//
//    @Bean
//    public MessageProducer inbound() {
//        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn",
//                mqttpahoClientFactory(), "#");
//        adapter.setCompletionTimeout(5000);
//        adapter.setConverter(new DefaultPahoMessageConverter());
//        adapter.setQos(2);
//        adapter.setOutputChannel(mqttInputChannel());
//        return adapter;
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "mqttInputChannel")
//    public MessageHandler handler() {
//        return new MessageHandler() {
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
//                if (topic.equals("tempC")) {
////                    System.out.println("This is our topic");
////                    System.out.println(message.getPayload());
//                    double recievedTemp = Double.parseDouble(message.getPayload().toString());
//                    Temp temp = new Temp(recievedTemp);
////                    System.out.println(temp);
//                    service.saveTemp(temp);
//                }
//                // System.out.println(message.getPayload());
//            }
//        };
//    }
//
//    @Bean
//    public MessageChannel mqttOutboundChannel() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "mqttOutboundChannel")
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttpahoClientFactory());
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic("#");
//        return messageHandler;
//    }

}
