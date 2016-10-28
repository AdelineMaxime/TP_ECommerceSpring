package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommDao {

	public void addLigneCommDao(LigneCommande lc);
	public void deleteLigneCommDao(LigneCommande lc);
	public void updateLigneCommDao(int qte);
	public List<LigneCommande> getAllLigneCommDao();

}
