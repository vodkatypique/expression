import java.security.InvalidKeyException;

public class BinairePow extends ExpBinaire {

    public BinairePow(ExpAbstraite e1, ExpAbstraite e2){
        this.setOpGauche(e1);
        this.setOpDroit(e2);
    }


    @Override
    String toStringInfixe() {
        return this.factoToString("^");
    }

    @Override
    double evaluer(Env env) throws InvalidKeyException {
        return Math.pow(this.getOpGauche().evaluer(env), this.getOpDroit().evaluer(env));
    }

    @Override
    ExpAbstraite calculerDerivee(String x) {
        //https://wallu.pagesperso-orange.fr/pag-deriv.htm
        return new BinaireMult(
                new BinairePow(
                        this.getOpGauche(),
                        this.getOpDroit()
                ),
                new BinairePlus(
                        new BinaireMult(
                                this.getOpGauche().calculerDerivee(x),
                                new BinaireMult(
                                        this.getOpDroit(),
                                        new BinairePow(this.getOpGauche(), new Constante(-1))
                                )),
                        new BinaireMult(
                                this.getOpDroit().calculerDerivee(x),
                                new UnaireLn(this.getOpGauche())
                        )

                )
        );
    }
}