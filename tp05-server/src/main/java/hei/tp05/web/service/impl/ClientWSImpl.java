package hei.tp05.web.service.impl;

import hei.tp05.contract.dto.ClientDTO;

import javax.inject.Named;
import javax.jws.WebService;

/**
 * Created by Thomas on 31/01/2017.
 */

@Named("clientWS")
@WebService(endpointInterface = "hei.tp05.contract.facade.ClientWS")
public class ClientWSImpl extends ClientDTO {


}
