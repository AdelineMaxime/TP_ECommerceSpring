package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IPanierDao;
import fr.adaming.model.Panier;

@Service
public class PanierServiceImpl implements IPanierService {

	
	@Autowired
	private IPanierDao panierService;
	
	@Override
	public void addPanierService(Panier panier) {

		panierService.addPanierDao(panier);
	}

}
