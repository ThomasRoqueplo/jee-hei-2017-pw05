package hei.tp05.web.config;

import hei.tp05.contract.facade.ClientWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.inject.Inject;
import javax.xml.ws.Endpoint;

/**
 * Created by Thomas on 31/01/2017.
 */
@Configuration
@ComponentScan(basePackages = { "hei.tp05.web.service.impl" })
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class WSConfig {

    @Inject
    private ClientWS clientWS;

    @Inject
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, clientWS);
        endpoint.setAddress("/client");
        endpoint.publish();
        return endpoint;
    }
}
