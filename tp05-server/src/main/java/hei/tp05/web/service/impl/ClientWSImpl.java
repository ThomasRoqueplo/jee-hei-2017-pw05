package hei.tp05.web.service.impl;

import hei.tp05.contract.dto.ClientDTO;
import hei.tp05.contract.facade.ClientWS;
import hei.tp05.core.entity.Client;
import hei.tp05.core.service.ClientService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 31/01/2017.
 */

@Named("clientWS")
@WebService(endpointInterface = "hei.tp05.contract.facade.ClientWS")
public class ClientWSImpl implements ClientWS{
    @Inject
    ClientService clientService;

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> listClient = clientService.findAll();
        List<ClientDTO> listClientDTO = new ArrayList<ClientDTO>();

        listClient.forEach(client -> {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setNom(client.getNom());
            clientDTO.setPrenom(client.getPrenom());
            listClientDTO.add(clientDTO);
        });

        return listClientDTO;
    }

    @Override
    public void saveClient(ClientDTO clientDTO) {
        Client client =new Client();
        client.setPrenom(clientDTO.getPrenom());
        client.setNom(clientDTO.getNom());
        clientService.saveClient(client);
    }
}
