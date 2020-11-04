import java.security.InvalidKeyException;

public abstract class ExpAbstraite {
    abstract String toStringInfixe();

    @Override
    public String toString() {
        return "Je suis une expression et me voila en notation infixée :"
                + this.toStringInfixe();
    }

    abstract double evaluer(Env env) throws InvalidKeyException;

    boolean parenthesisIsNotNecessy(){
        return false;
    }

    abstract ExpAbstraite calculerDerivee(String x);
}
