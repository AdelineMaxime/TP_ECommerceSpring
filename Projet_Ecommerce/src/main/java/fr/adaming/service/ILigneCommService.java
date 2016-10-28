package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommService {

	public void addLigneCommService(LigneCommande lc);
	public void deleteLigneCommService(LigneCommande lc);
	public void updateLigneCommService(int qte);
	public List<LigneCommande> getAllLigneCommService();
	
}
