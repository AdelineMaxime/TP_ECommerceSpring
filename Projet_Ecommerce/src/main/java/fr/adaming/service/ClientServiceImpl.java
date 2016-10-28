package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService {

	
	@Autowired
	private IClientDao clientDao;
	
	@Override
	public void addClientService(Client client) {

		clientDao.addClientDao(client);
	}

	@Override
	public int isExistClientService(String nom, String password) {

		return clientDao.isExistClientDao(nom, password);
	}

}
