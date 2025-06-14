package distributore;

// Classe che rappresenta un'eccezione personalizzata
public class EccezioneBevandaNonDisponibile extends Exception {

    // Costruttore: riceve un messaggio e lo passa alla superclasse Exception
    public EccezioneBevandaNonDisponibile(String messaggio) {
        super(messaggio); // Il messaggio verrà mostrato quando l'eccezione sarà catturata
    }
}