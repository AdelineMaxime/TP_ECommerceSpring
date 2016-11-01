package fr.adaming.dao;

import fr.adaming.model.Client;

public interface IClientDao {

	public void addClientDao(Client client);
	public int isExistClientDao(String nom, String password);
	public int isExistClientDao(String nom);
	
	
}
