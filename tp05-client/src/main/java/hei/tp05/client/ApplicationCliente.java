package hei.tp05.client;

import hei.tp05.contract.dto.ClientDTO;
import hei.tp05.contract.facade.ClientWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Thomas on 31/01/2017.
 */
public class ApplicationCliente {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationCliente.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("hei.tp05.client.config");
        ClientWS clientWS2 = context.getBean(ClientWS.class);
        LOGGER.info("Je crée un nouveau client !");
        clientWS2.saveClient(new ClientDTO("Thomas", "OuiOUi"));
        LOGGER.info("Je retourne la liste des clients !");
        clientWS2.getAllClients().forEach(System.out::println);
    }
}
