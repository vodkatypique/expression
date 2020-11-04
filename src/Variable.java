import java.security.InvalidKeyException;

public class Variable extends ExpAbstraite {
    private String nom;

    public Variable(String nom){
        this.nom = nom;
    }

    @Override
    String toStringInfixe() {
        return this.nom;
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return env.obtenirValeur(this.nom);
    }

    @Override
    boolean parenthesisIsNotNecessy() {
        return true;
    }
}
