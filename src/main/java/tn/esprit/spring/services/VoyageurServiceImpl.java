package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Voyageur;


import tn.esprit.spring.repository.VoyageurRepository;


@Service
public class VoyageurServiceImpl implements IVoyageurService{

	@Autowired
	VoyageurRepository voyageurRepository;

//	
//	private static final Logger l = LogManager.getLogger(voyageurServiceImpl.class);
//	
	public Voyageur ajouterVoyageur(Voyageur voyageur) {
		voyageurRepository.save(voyageur);
		return voyageur;
		
    }

	@Override
	public Voyageur modifierVoyageur(Voyageur voyageur) {
		voyageurRepository.save(voyageur);
		return voyageur ;
	}

	@Override
	public List<Voyageur> recupererAll() {
		List<Voyageur> list= (List<Voyageur>) voyageurRepository.findAll();
		//Afficher la liste des voyageurs
		for (Voyageur v: list) {
			System.err.print("Voyageur");
			System.out.print(v.toString()+"\n");
		}
		return list;
	}

	@Override
	public Voyageur recupererVoyageParId(long idVoyageur) {
		//TODO
		return null;
	}

	@Override
	public void supprimerVoyageur(Voyageur v) {
		voyageurRepository.delete(v);
	}

}
