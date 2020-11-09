import java.security.InvalidKeyException;

public class UnaireExp extends ExpUnaire {
    @Override
    String toStringInfixe() {
        return "exp("+this.getOperande().toStringInfixe()+")";
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return Math.exp(this.getOperande().evaluer(env));
    }

    public UnaireExp(ExpAbstraite e1){
        this.setOperande(e1);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinaireMult(
                this.getOperande().calculerDerivee(x),
                new UnaireExp(
                        this.getOperande()
                )
        );
    }
}
