package ma.ensao.youmna.service;

import ma.ensao.youmna.model.Compte;

public interface CompteService {
	void createCompte(Compte compte);
	void sendMessage(String to, String subject, String message);
}
