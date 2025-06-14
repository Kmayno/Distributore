package distributore;

import java.util.ArrayList;

public class Distributore {

	// Attributi
	private ArrayList<Bevanda> catalogo; // Elenco di tutte le bevande disponibili
	private double incassoTot;           // Incasso totale del distributore
	private double credito;              // Credito inserito dal cliente

	// Costruttore: inizializza il catalogo con alcune bevande predefinite
	public Distributore() {
		catalogo = new ArrayList<>();
		incassoTot = 0.0;
		credito = 0.0;

		// Bevande iniziali
		catalogo.add(new Bevanda("CocaCola", "01", 2.50, 10));
		catalogo.add(new Bevanda("Fanta", "02", 2.60, 10));
		catalogo.add(new Bevanda("Sprite", "03", 2.00, 10));
		catalogo.add(new Bevanda("Monster Ultra Violet", "04", 3.00, 10));
		catalogo.add(new Bevanda("Birra", "05", 3.50, 1));
	}

	// Getter e setter
	public ArrayList<Bevanda> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<Bevanda> catalogo) {
		this.catalogo = catalogo;
	}

	public double getIncassoTot() {
		return incassoTot;
	}

	public void setIncassoTot(double incassoTot) {
		this.incassoTot = incassoTot;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	// Metodo per acquistare una bevanda tramite codice
	public void acquistaBevanda(String codice) throws EccezioneBevandaNonDisponibile {
	    boolean trovata = false;

	    for (Bevanda b : catalogo) {
	        if (b.getCodice().equalsIgnoreCase(codice)) {
	            trovata = true;

	            // Controlla se la bevanda è esaurita
	            if (b.getQuantita() <= 0) {
	                throw new EccezioneBevandaNonDisponibile("Bevanda esaurita: " + b.getNome());
	            }

	            // Verifica credito sufficiente
	            if (credito >= b.getPrezzo()) {
	                b.setQuantita(b.getQuantita()-1);
	                credito -= b.getPrezzo();
	                incassoTot += b.getPrezzo();
	                System.out.println("Bevanda erogata: " + b.getNome());
	            } else {
	                System.out.println("Credito insufficiente.");
	            }
	            return; // Una volta trovata ed elaborata la bevanda, esce dal metodo
	        }
	    }

	    // Se non è stato trovato nessun codice corrispondente
	    if (!trovata) {
	        throw new EccezioneBevandaNonDisponibile("Codice non valido: nessuna bevanda trovata.");
	    }
	}

	// Aggiunge una nuova bevanda al catalogo
	public void aggiungiBevanda(Bevanda b) {
		catalogo.add(b);
	}

	// Rimuove una bevanda dal catalogo dato il codice
	public void rimuoviBevanda(String codice) {
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getCodice().equalsIgnoreCase(codice)) {
				catalogo.remove(i);
				return;
			}
		}
	}

	// Modifica il prezzo di una bevanda
	public void modificaPrezzo(String codice, double nuovoPrezzo) {
		for (Bevanda i : catalogo) {
			if (i.getCodice().equalsIgnoreCase(codice)) {
				i.setPrezzo(nuovoPrezzo);
				return;
			}
		}
	}

	// Aggiunge una certa quantità a una bevanda esistente
	public void rifornisci(String codice, int nuove) {
		for (Bevanda i : catalogo) {
			if (i.getCodice().equalsIgnoreCase(codice)) {
				i.setQuantita(i.getQuantita() + nuove);
			}
		}
	}

	// Stampa tutte le bevande presenti nel catalogo
	public void stampaInventario() {
		for (Bevanda i : catalogo) {
			System.out.println(i);
		}
	}

	// Azzera il credito del cliente
	public void azzeraCredito() {
		credito = 0;
	}

	// Azzera l’incasso totale
	public void azzeraIncasso() {
		incassoTot = 0;
	}

	// Aggiunge credito al distributore
	public void aggiungiCredito(double inputUtente) {
		credito += inputUtente;
	}
}