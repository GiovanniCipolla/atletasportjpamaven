package it.prova.atletasportjpamaven.test;

import java.util.List;

import it.prova.atletasportjpamaven.dao.EntityManagerUtil;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;
import it.prova.atletasportjpamaven.service.MyServiceFactory;
import it.prova.atletasportjpamaven.service.atleta.AtletaService;
import it.prova.atletasportjpamaven.service.sport.SportService;

public class TestAtletasportjpamaven {
	public static void main(String[] args) {

		AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();
		SportService sportServinceInstance = MyServiceFactory.getSportServiceInstance();

		try {

//			=========================AGGIUNGERE UN METODO ======================
			
			// -------------------------TEST----------------
//			System.out.println(atletaServiceInstance.lista());

//			testLeggi(atletaServiceInstance);

//			testAggiorna(atletaServiceInstance);

//			testInserisci(atletaServiceInstance);

//			testRimuovi(atletaServiceInstance);
			
//			testLeggi(sportServinceInstance);
			
//			testAggiorna(sportServinceInstance);
			
//			testInserisci(sportServinceInstance);
			
//			testRimuovi(sportServinceInstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	// -------------------------------------- TEST
	// -----------------------------------
	// -------------------------------- TEST CRUD ATLETA
	// --------------------------------------
	private static void testLeggi(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("...................... INIZIO TEST ..................");
		
		
		Long idDaLeggere = 1l;
		
		System.out.println(atletaServiceInstance.leggi(idDaLeggere));

		System.out.println("...................... FINE TEST ..................");
	}

	private static void testAggiorna(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("...................... INIZIO TEST ..................");

		List<Atleta> result = atletaServiceInstance.lista();
		Atleta daMoficare = result.get(0);
		daMoficare.setNome("Usain");
		atletaServiceInstance.aggiorna(daMoficare);
		List<Atleta> result2 = atletaServiceInstance.lista();
		System.out.println(result2.get(0));

		System.out.println("...................... FINE TEST ..................");
	}

	private static void testInserisci(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("...................... INIZIO TEST ..................");


		int misuraDiControllo = atletaServiceInstance.lista().size();
		Atleta daInserire = new Atleta();
		daInserire.setNome("aaaaaaaaaaa");

		atletaServiceInstance.inserisci(daInserire);
		
		if(atletaServiceInstance.lista().size() != misuraDiControllo+1)
			throw new RuntimeException("TEST FAILED: ERRORE NELL'INSERIMENTO");
		
		System.out.println(atletaServiceInstance.lista());

		System.out.println("...................... FINE TEST ..................");
	}

	private static void testRimuovi(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("...................... INIZIO TEST ..................");

		List<Atleta> result = atletaServiceInstance.lista();
		
		
		Atleta daRimuovere = result.get(result.size() - 1);

		atletaServiceInstance.rimuovi(daRimuovere);
		
		if(result.size()-1 != atletaServiceInstance.lista().size())
			throw new RuntimeException("TEST FAILED: ERRORE NELLA RIMOZIONE");

		System.out.println(atletaServiceInstance.lista());

		System.out.println("...................... FINE TEST ..................");
	}

	// ------------------------------- TEST CRUD SPORT ---------------------
	
	private static void testLeggi(SportService sportServiceInstance)throws Exception {
		System.out.println("...................... INIZIO TEST ..................");
		
		Long idDaLeggere = 1l;

		System.out.println(sportServiceInstance.leggi(idDaLeggere));
		
		System.out.println("...................... FINE TEST ..................");
	}
	private static void testAggiorna(SportService sportServiceInstance)throws Exception {
		System.out.println("...................... INIZIO TEST ..................");
		List<Sport> result = sportServiceInstance.lista();
		
		Sport daModificare = result.get(0);
		
		daModificare.setDescrizione("finale olimpiade boxe");
		
		sportServiceInstance.aggiorna(daModificare);
		
		List<Sport> result2 = sportServiceInstance.lista();
		
		System.out.println(result2.get(0));
		
		
		System.out.println("...................... FINE TEST ..................");
	}
	private static void testInserisci(SportService sportServiceInstance)throws Exception {
		System.out.println("...................... INIZIO TEST ..................");
		
		
		int indicePerControllo = sportServiceInstance.lista().size();	
		
		Sport daInserire = new Sport();
		
		daInserire.setDescrizione("aaaaaaaaaaaaaa");
		
		sportServiceInstance.inserisci(daInserire);
		
		if(indicePerControllo+1 != sportServiceInstance.lista().size())
			throw new RuntimeException("TEST FAILED: ERRORE NELL'INSERIMENTO");
		
		System.out.println(sportServiceInstance.lista());
		
		System.out.println("...................... FINE TEST ..................");
	}
	private static void testRimuovi(SportService sportServiceInstance)throws Exception {
		System.out.println("...................... INIZIO TEST ..................");
		
		List<Sport> result = sportServiceInstance.lista();
		
		int indicePerControllo = result.size();
		Sport daRimuovere = result.get(result.size()-1);
		
		sportServiceInstance.rimuovi(daRimuovere);
		
		if(indicePerControllo-1 != sportServiceInstance.lista().size())
			throw new RuntimeException("TEST FAILED: ERRORE NELLA RIMOZIONE");
			
		System.out.println(sportServiceInstance.lista());
		
		System.out.println("...................... FINE TEST ..................");
	}
	
}
