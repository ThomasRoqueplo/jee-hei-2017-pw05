package hei.tp05.client.config;

import hei.tp05.contract.facade.ClientWS;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Thomas on 31/01/2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public ClientWS clientWS() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(ClientWS.class);
        factoryBean.setAddress("http://localhost:8080/tp05-server/services/client");
        return factoryBean.create(ClientWS.class);
    }
}
