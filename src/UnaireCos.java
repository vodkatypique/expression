import java.security.InvalidKeyException;

public class UnaireCos extends ExpUnaire {
    @Override
    String toStringInfixe() {
        return "cos("+this.getOperande().toStringInfixe()+")";
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return Math.cos(this.getOperande().evaluer(env));
    }

    public UnaireCos(ExpAbstraite e1){
        this.setOperande(e1);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinaireMult(
                new BinaireMult(
                        new Constante(-1),
                        this.getOperande().calculerDerivee(x)
                ),
                new UnaireSin(
                        this.getOperande()
                )
        );
    }
}
