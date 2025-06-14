package distributore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
	Scanner scanner = new Scanner(System.in); // Scanner per input da tastiera

	// Password predefinita per accedere come Admin
	private final String passFinal = "12345";

	// Riferimento al distributore su cui l'admin può operare
	private Distributore distributore;

	// Costruttore: l'admin riceve una copia del distributore da gestire
	public Admin(Distributore distributore) {
		this.distributore = distributore;
	}

	// Metodo per verificare la password inserita dall'utente
	public boolean verificaPass(String password) {
		// Confronta con la password corretta
		return passFinal.equals(password);
	}

	// Menu delle funzionalità riservate all'admin
	public void menuAdmin() {
		int scelta; // Scelta dell'admin nel menu

		do {
			// Stampa delle opzioni disponibili
			System.out.println("Benvenuto nel menu Admin.");
			System.out.println("1) Visualizza Inventario.");
			System.out.println("2) Aggiungi una bevanda.");
			System.out.println("3) Rimuovi una bevanda.");
			System.out.println("4) Modifica il prezzo di una bevanda.");
			System.out.println("5) Rifornisci una bevanda.");
			System.out.println("6) Visualizza incasso.");
			System.out.println("7) Azzera credito cliente.");
			System.out.println("8) Azzera incasso.");
			System.out.println("9) Esci dal menu Admin.");

			// Lettura della scelta
			scelta = scanner.nextInt();

			switch (scelta) {
			case 1:
				// Visualizza tutto l'inventario delle bevande
				distributore.stampaInventario();
				break;

			case 2:
				// Aggiunta di una nuova bevanda al distributore
				System.out.println("Inserisci nome della bevanda:");
				String nome = scanner.next();
				scanner.nextLine(); // pulizia buffer

				System.out.println("Inserisci codice:");
				String codice = scanner.next();
				scanner.nextLine();

				//assegnazione del prezzo della bevanda
				Double prezzo = 0.0;
				//boolean di controllo
				boolean verificaPrezzo = false;
				//gestione degli errori "inputMismatch" e "numero negativo"
				while(!verificaPrezzo){
					System.out.println("Inserisci prezzo della bevanda:");
					try{
						prezzo = scanner.nextDouble();
						scanner.nextLine();
						if(prezzo>=0){
							verificaPrezzo=true;
						}else{
							System.out.println("Inserisci un numero positivo.");
						}
					}catch(InputMismatchException e){
						System.out.println("Errore: inserisci un numero.");
						scanner.nextLine();
					}
				}

				int quantita=0;
				boolean verificaQuantita=false;
				while(!verificaQuantita){
					System.out.println("Inserisci la quantità:");
					try{
						quantita = scanner.nextInt();
						scanner.nextLine();
						if(quantita>0){
							verificaQuantita=true;
						}else{
							System.out.println("Inserisci un numero positivo.");
						}
					}catch(InputMismatchException e){
						System.out.println("Errore: inserisci un numero.");
						scanner.nextLine();
					}
				}


				//scanner.nextLine();

				// Crea nuova bevanda e la aggiunge al catalogo
				distributore.aggiungiBevanda(new Bevanda(nome, codice, prezzo, quantita));
				break;

			case 3:
				// Rimozione di una bevanda tramite codice
				System.out.println("Inserisci il codice della bevanda che vuoi rimuovere:");
				String codiceRimuovi = scanner.next();
				//scanner.nextLine();
				distributore.rimuoviBevanda(codiceRimuovi);
				break;

			case 4:
				// Modifica del prezzo di una bevanda esistente
				System.out.println("Inserisci il codice della bevanda:");
				String codiceModPrezzo = scanner.next();
				scanner.nextLine();

				Double nuovoPrezzo = 0.0;
				boolean verificaNuovoPrezzo =false;
				//while per il try catch, finche' l'utente non inserisce un int non esce dal ciclo
				while (!verificaNuovoPrezzo) {
					System.out.println("Inserisci il nuovo prezzo:");
					try {
						nuovoPrezzo = scanner.nextDouble();
						scanner.nextLine();
						//il numero inserito deve essere per forza positivo
						if(nuovoPrezzo>0) {
							verificaNuovoPrezzo = true;
						} else{
							System.out.println("Inserisci un numero positivo.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Errore. Inserisci un numero.");
						scanner.nextLine();
					}
				}

				distributore.modificaPrezzo(codiceModPrezzo, nuovoPrezzo);
				break;

			case 5:
				// Rifornimento di una bevanda
				System.out.println("Inserisci il codice della bevanda da rifornire:");
				String codiceRifornimento = scanner.next();
				scanner.nextLine();

				int quantitaDaAggiungere = 0;
				boolean verificaQuantitaAggiunta = false;
				while (!verificaQuantitaAggiunta) {
					System.out.println("Inserisci la nuova quantità:");
					try {
						quantitaDaAggiungere = scanner.nextInt();
						scanner.nextLine();
						verificaQuantitaAggiunta = true;
					} catch (InputMismatchException e) {
						System.out.println("Errore: inserisci un numero.");
						scanner.nextLine();
					}
				}

				distributore.rifornisci(codiceRifornimento, quantitaDaAggiungere);
				break;

			case 6:
				// Visualizzazione incasso totale del distributore
				System.out.println("L'incasso totale è: " + distributore.getIncassoTot() + " euro.");
				break;

			case 7:
				// Azzera il credito dell'utente (cliente)
				distributore.azzeraCredito();
				break;

			case 8:
				// Azzera l'incasso totale
				distributore.azzeraIncasso();
				break;

			case 9:
				// Esce dal menu admin
				System.out.println("Uscita dal menu Admin.");
				return;

			default:
				// Messaggio per input non valido
				System.out.println("Inserisci un numero valido.");
			}

		} while (scelta != 9); // Ripeti finché l'admin non sceglie di uscire
	}
}