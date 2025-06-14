package distributore;

public class Bevanda {

    // Attributi della bevanda
    private String nome;      // Nome della bevanda (es: CocaCola)
    private String codice;    // Codice identificativo della bevanda (es: "01")
    private double prezzo;    // Prezzo in euro
    private int quantita;     // Quantità disponibile in magazzino

    // Costruttore: inizializza tutti i campi della bevanda
    public Bevanda(String nome, String codice, double prezzo, int quantita) {
        this.nome = nome;
        this.codice = codice;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    // Getter e Setter per ogni attributo
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCodice() {

        return codice;
    }

    public void setCodice(String codice) {

        this.codice = codice;
    }

    public double getPrezzo() {

        return prezzo;
    }

    public void setPrezzo(double prezzo) {

        this.prezzo = prezzo;
    }

    public int getQuantita() {

        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }


    // Verifica se la bevanda è disponibile (quantità > 0)
    // Rappresentazione in formato stringa della bevanda (utile per stampa inventario)
    @Override
    public String toString() {
        return "Nome: " + nome + ", Codice: " + codice + ", Prezzo: " + prezzo +"€"+ ", Quantita: " + quantita;
    }
}