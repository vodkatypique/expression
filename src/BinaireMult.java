import java.security.InvalidKeyException;

public class BinaireMult extends ExpBinaire {

    public BinaireMult(ExpAbstraite e1, ExpAbstraite e2){
        this.setOpGauche(e1);
        this.setOpDroit(e2);
    }


    @Override
    String toStringInfixe() {
        return this.factoToString("*");
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return this.getOpGauche().evaluer(env)*this.getOpDroit().evaluer(env);
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        return new BinairePlus(
                new BinaireMult(
                        this.getOpGauche().calculerDerivee(x),
                        this.getOpDroit()
                ),
                new BinaireMult(
                        this.getOpDroit().calculerDerivee(x),
                        this.getOpGauche()
                )
        );
    }
}
