package distributore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

	// Attributo: riferimento al distributore associato al cliente
	Distributore distributore;

	// Costruttore: collega il cliente al distributore
	public Cliente(Distributore distributore) {

		this.distributore = distributore;
	}

	// Menu per l'interazione con il cliente
	public void menu() {
		Scanner input = new Scanner(System.in); // Scanner per input utente

		while (true) {
			// Stampa del menu cliente
			System.out.println("Benvenuto.");
			System.out.println("Credito attuale: " + distributore.getCredito() + " €");
			System.out.println("1 - Inserisci credito");
			System.out.println("2 - Visualizza l'inventario");
			System.out.println("3 - Acquista bevanda");
			System.out.println("4 - Eroga resto");
			System.out.println("5 - Esci");
			System.out.print("Scegli un'opzione: ");

			// Lettura della scelta
			int scelta = input.nextInt();

			switch (scelta) {
				case 1:
					// Inserimento di credito
					System.out.print("Inserisci importo da aggiungere: ");
					Double importo=0.0;
					boolean verificaImporto=false;

					while(!verificaImporto) {
						try {
							importo = input.nextDouble();
							if (importo > 0) {
								distributore.aggiungiCredito(importo);
								verificaImporto=true;
							} else {
								System.out.println("inserisci importo positivo.");
							}
						} catch (InputMismatchException e) {
							System.out.println("inserisci un importo valido.");
							input.nextLine();
						}
					}

					break;

				case 2:
					// Visualizzazione catalogo delle bevande
					distributore.stampaInventario();
					break;

				case 3:
					// Acquisto di una bevanda tramite codice
					System.out.println("Inserisci il codice della bevanda da acquistare:");
					String codice = input.next(); // lettura codice
					try {
						distributore.acquistaBevanda(codice); // può generare un'eccezione
					} catch (EccezioneBevandaNonDisponibile e) {
						// Gestione eccezione: bevanda non disponibile o codice errato
						System.err.println("Errore: " + e.getMessage());
					}
					break;

				case 4:
					// Eroga il resto azzerando il credito
					distributore.azzeraCredito();
					break;

				case 5:
					// Uscita dal menu cliente
					System.out.println("Uscita dal menu cliente.");
					return;

				default:
					// Gestione di input non validi
					System.out.println("Opzione non valida, riprova per favore.");
			}
		}
	}
}