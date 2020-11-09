import java.security.InvalidKeyException;

public class UnaireLn extends ExpUnaire {
    @Override
    String toStringInfixe() {
        return "ln("+this.getOperande().toStringInfixe()+")";
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return Math.log(this.getOperande().evaluer(env));
    }

    public UnaireLn(ExpAbstraite e1){
        this.setOperande(e1);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinaireMult(
                this.getOperande().calculerDerivee(x),
                new BinairePow(
                        this.getOperande(),
                        new Constante(-1)
                )
        );
    }
}
