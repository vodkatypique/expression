import java.security.InvalidKeyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinairePlus extends ExpBinaire {
    @Override
    String toStringInfixe() {
        String retour = factoToString("+");
        /*Pattern p = Pattern.compile("(\\d+\\.\\d+)\\+(\\d+\\.\\d+)");
        Matcher m = p.matcher(retour);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            double rep = Double.parseDouble(m.group(1))+Double.parseDouble(m.group(2));
            m.appendReplacement(sb, String.valueOf(rep));
        }
        m.appendTail(sb);
        retour = sb.toString();*/
        return retour;
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
