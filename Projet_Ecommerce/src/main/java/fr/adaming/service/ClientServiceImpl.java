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

	/**
	 * Créer un nouveau client
	 */
	@Override
	public void addClientService(Client client) {

		clientDao.addClientDao(client);
	}

	/**
	 * Vérifier s'il existe un compte avec le nom et le mdp proposés Retourne 0
	 * s'il n'en existe pas
	 */
	@Override
	public int isExistClientService(String nom, String password) {

		return clientDao.isExistClientDao(nom, password);
	}

	/**
	 * Vérifier s'il existe déjà un compte avec le même nom de client Retourne 0
	 * s'il n'en existe pas
	 */
	@Override
	public int isExistClientService(String nom) {

		return clientDao.isExistClientDao(nom);
	}

}
