package fr.adaming.service;

import fr.adaming.model.Client;

public interface IClientService {

	public void addClientService(Client client);
	public int isExistClientService(String nom, String password);
	int isExistClientService(String nom);
	public Client getClientByNameDao(String nomClient);
	
}
