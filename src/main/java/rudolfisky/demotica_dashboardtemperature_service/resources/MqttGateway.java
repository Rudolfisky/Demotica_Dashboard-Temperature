package rudolfisky.demotica_dashboardtemperature_service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {


    void senToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
