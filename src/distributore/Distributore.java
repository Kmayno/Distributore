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
        catalogo.add(new Bevanda("Birra Peroni", "05", 3.50, 1));
    }

    // Getter e setter
    public ArrayList<Bevanda> getCatalogo() {
        return catalogo;
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
                    b.setQuantita(b.getQuantita() - 1);
                    setCredito(getCredito() - b.getPrezzo());
                    setIncassoTot(getIncassoTot() + b.getPrezzo());
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
        //controllo se il codice della bevanda e' occupato nell'ArrayList catalogo
        boolean codiceOccupato = false;
        int i = 0;
        //while aggiunto per divertimento (cercavo una soluzione piu elegante del break :3)
        while (i < catalogo.size() && !codiceOccupato) {
            if (b.getCodice().equalsIgnoreCase(catalogo.get(i).getCodice())) {
                //setto il booleano a true se e' stato trovato un codice corrispondente
                codiceOccupato = true;
                System.out.println("Codice non disponibile. Riprovare.");
            }
            i++;
        }
        if (!codiceOccupato) {
            //se il codice della bevanda non esiste allora procedo ad aggiungerla nell' ArrayList catalogo
            catalogo.add(b);
            System.out.println("Bevanda: " + b.getNome() + " aggiunta con successo.");
        }
    }

    // Rimuove una bevanda dal catalogo dato il codice
    public void rimuoviBevanda(String codice) {
        //controllo per verificare se il codice della bevanda e' gia presente nell'ArrayList catalogo
        boolean controlloBevanda = false;

        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getCodice().equalsIgnoreCase(codice)) {
                //rimuove la bevanda se e' stato trovato il codice corrispondente e setta il booleano di controllo a true
                catalogo.remove(i);
                controlloBevanda = true;
                System.out.println("la bevanda e' stata rimossa con successo");
                break;
            }
        }
        if (!controlloBevanda) {
            //se il booleano dopo il ciclo e' ancora false stampa messaggio di errore
            System.err.println("Codice non trovato. Riprova.");
        }
    }

    // Modifica il prezzo di una bevanda
    public void modificaPrezzo(String codice, double nuovoPrezzo) {
        // setto un boolean per controllare se il codice viene trovato
        boolean trovata = false;
        for (Bevanda i : catalogo) {
            if (i.getCodice().equalsIgnoreCase(codice)) {
                //se il codice della bevanda viene trovato setto il nuovo prezzo e il boolean a true ed esco dal ciclo
                i.setPrezzo(nuovoPrezzo);
                System.out.println("Nuovo prezzo: " + i.getPrezzo() + "€" + " per la bevanda: " + i.getNome());
                trovata = true;
                break;
            }
        }
        if (!trovata) {
            //se il codice non viene trovato stampo errore
            System.err.println("Nessuna bevanda trovata con il codice: " + codice);
        }
    }

    // Aggiunge una certa quantità a una bevanda esistente
    public void rifornisci(String codice, int nuove) {
        boolean rifornisciCodiceOccupato = false;
        for (Bevanda i : catalogo) {
            if (i.getCodice().equalsIgnoreCase(codice)) {
                i.setQuantita(i.getQuantita() + nuove);
                rifornisciCodiceOccupato = true;
                System.out.println("Hai rifornito la bevanda: " + i.getNome() + " di " + nuove + " unita'");
            }
        }
        if (!rifornisciCodiceOccupato) {
            System.err.println("Nessuna bevanda trovata con il codice: " + codice);
        }
    }

    // Stampa tutte le bevande presenti nel catalogo
    public void stampaInventario() {
        for (Bevanda i : catalogo) {
            System.out.println(i);
        }
    }

    public void azzeraCredito() {
        //controlla se il credito e' superiore a zero
        if (getCredito() <= 0) {
            System.err.println("Nessun credito da erogare.");
        } else {
            System.out.println("Erogazione di " + getCredito() + "€  in corso...");
            // Azzera il credito del cliente
            setCredito(0);
        }
    }

    // Azzera l’incasso totale
    public void azzeraIncasso() {
        setIncassoTot(0);
    }

    // Aggiunge credito al distributore
    public void aggiungiCredito(double inputUtente) {
        setCredito(getCredito() + inputUtente);
    }
}