package it.prova.atletasportjpamaven.test;


import it.prova.atletasportjpamaven.dao.EntityManagerUtil;
import it.prova.atletasportjpamaven.service.MyServiceFactory;
import it.prova.atletasportjpamaven.service.atleta.AtletaService;
import it.prova.atletasportjpamaven.service.sport.SportService;

public class TestAtletasportjpamaven {
public static void main(String[] args) {
	
	AtletaService utenteServiceInstance = MyServiceFactory.getAtletaServiceInstance();
	SportService sportServinceInstance = MyServiceFactory.getSportServiceInstance();
	
	try {
		
		
		// -------------------- CONTROLLARE ENTITA' E CLASSI PRIMA DI CREATE ----------------------
		
		
	}catch (Throwable e) {
		e.printStackTrace();
	} finally {
		// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
		// main
		EntityManagerUtil.shutdown();
	}
	
	
	
	
	
	
	
}
}
