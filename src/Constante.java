import java.security.InvalidKeyException;

public class Constante extends ExpAbstraite implements Evaluable{
    private double valeur;

    public Constante(double valeur){
        this.valeur = valeur;
    }

    @Override
    String toStringInfixe() {
        return Double.toString(this.valeur);
    }

    @Override
    double evaluer(Env env) {
        return this.valeur;
    }

    @Override
    boolean parenthesisIsNotNecessy() {
        return true;
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new Constante(0);
    }

    @Override
    public double evaluer() throws InvalidKeyException {
        return this.valeur;
    }
}
