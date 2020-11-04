import java.security.InvalidKeyException;

public class UnaireSin extends ExpUnaire {
    @Override
    String toStringInfixe() {
        return "sin("+this.getOperande().toStringInfixe()+")";
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return Math.sin(this.getOperande().evaluer(env));
    }

    public UnaireSin(ExpAbstraite e1){
        this.setOperande(e1);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinaireMult(
                this.getOperande().calculerDerivee(x),
                new UnaireCos(
                        this.getOperande().calculerDerivee(x)
                )
        );
    }
}
