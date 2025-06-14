package distributore;

import java.util.Scanner;

public class MainDistributore {

	public static void main(String[] args) {
		int scelta; // Variabile per memorizzare la scelta dell'utente
		Scanner inputUtente = new Scanner(System.in); // Scanner per input da tastiera

		// Creazione delle istanze del distributore, admin e cliente
		Distributore distributore = new Distributore();
		Admin admin = new Admin(distributore); // L'admin ha accesso al distributore
		Cliente cliente = new Cliente(distributore); // Anche il cliente ha accesso al distributore

		do {
			// Menu principale visualizzato ad ogni ciclo
			System.out.println("Benvenuto nel distributore della de nigro srl");
			System.out.println("Ecco la lista delle bevande fresche disponibili");
			distributore.stampaInventario(); // Stampa l'inventario delle bevande

			// Opzioni per l'utente
			System.out.println("cliccare 1 se sei un utente");
			System.out.println("cliccare 2 se sei un Admin");
			System.out.println("cliccare 3 se vuoi uscire");

			scelta = inputUtente.nextInt(); // Legge la scelta dell'utente

			switch (scelta) {
				case 1:
					// Se l'utente è un cliente, accede al menu cliente
					cliente.menu();
					break;
				case 2:
					// Se l'utente è un admin, viene chiesta la password
					//Scanner sceltaAdmin = new Scanner(System.in); non c'e' bisogno perche uso sempre inputUtente
					inputUtente.nextLine(); //pulisce il buffer dello scanner
					System.out.println("Inserisci la password");
					String password = inputUtente.nextLine();
					if (admin.verificaPass(password)) {
						// Se la password è corretta, mostra il menu admin
						admin.menuAdmin();
					} else {
						// Messaggio di errore se la password è sbagliata
						System.out.println("password errata. Accesso negato.");
					}
					break;
				case 3:
					// Messaggio di saluto all'uscita
					System.out.println("Arrivederci da Carmine");
					break;
				default:
					// Messaggio di errore per input non valido
					System.out.println("scelta non valida");
			}
			// Il ciclo continua finché l'utente non sceglie di uscire
		} while (scelta != 3);
	}
}