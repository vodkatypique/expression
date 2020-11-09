import java.security.InvalidKeyException;
import java.util.HashMap;

public class Env {
    private HashMap<String, Evaluable> dico;

    public Env(){
        this.dico = new HashMap<String, Evaluable>();
    }

    public void associer(String nom, Evaluable valeur){
        this.dico.putIfAbsent(nom, valeur);
    }

    public double obtenirValeur(String nom) throws InvalidKeyException {
        if (this.dico.containsKey(nom)){
            return this.dico.get(nom).evaluer();

        }else {
            throw new InvalidKeyException();
        }
    }

    @Override
    public String toString() {
        HashMap<String, Double> temp = new HashMap<String, Double>();
        for (String cle :
                this.dico.keySet()) {
            try {
                temp.put(cle, this.dico.get(cle).evaluer());
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        return temp.toString();
    }
}
