import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;

public class Env {
    private HashMap<String, Double> dico;

    public Env(){
        this.dico = new HashMap<String, Double>();
    }

    public void associer(String nom, double valeur){
        this.dico.putIfAbsent(nom, valeur);
    }

    public double obtenirValeur(String nom) throws InvalidKeyException {
        if (this.dico.containsKey(nom)){
            return this.dico.get(nom);

        }else {
            throw new InvalidKeyException();
        }
    }

    @Override
    public String toString() {
        return "Env{" +
                "dico=" + dico +
                '}';
    }
}
