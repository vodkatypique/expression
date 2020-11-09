import java.security.InvalidKeyException;

public class ExpressionEvaluable implements Evaluable {
    private ExpAbstraite exp;
    private Env contexte;

    public ExpressionEvaluable(ExpAbstraite e1, Env env){
        this.exp = e1;
        this.contexte = env;
    }
    @Override
    public double evaluer() throws InvalidKeyException {
        return this.exp.evaluer(this.contexte);
    }

    @Override
    public String toString() {
        return this.contexte.toString() + " --- " +this.exp.toStringInfixe();
    }
}
