import java.security.InvalidKeyException;

public class BinairePlus extends ExpBinaire {
    @Override
    String toStringInfixe() {
        return factoToString("+");
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return this.getOpGauche().evaluer(env)+this.getOpDroit().evaluer(env);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinairePlus(this.getOpGauche().calculerDerivee(x), this.getOpDroit().calculerDerivee(x));
    }


    public BinairePlus(ExpAbstraite e1, ExpAbstraite e2){
        this.setOpGauche(e1);
        this.setOpDroit(e2);
    }
}
