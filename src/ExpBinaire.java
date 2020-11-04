public abstract class ExpBinaire extends ExpAbstraite{
    private ExpAbstraite opGauche;
    private ExpAbstraite opDroit;

    protected ExpAbstraite getOpDroit() {
        return opDroit;
    }

    protected ExpAbstraite getOpGauche() {
        return opGauche;
    }

    protected void setOpDroit(ExpAbstraite opDroit) {
        this.opDroit = opDroit;
    }

    protected void setOpGauche(ExpAbstraite opGauche) {
        this.opGauche = opGauche;
    }

    protected String factoToString(String operateur) {
        boolean prioriteGauche = false;
        boolean prioriteDroit = false;
        if(operateur.equals("*")){
                    prioriteGauche = !(this.getOpGauche().getClass().getName().equals("Variable")||this.getOpGauche().getClass().getName().equals("Constante"));
                    prioriteDroit = !(this.getOpDroit().getClass().getName().equals("Variable")||this.getOpDroit().getClass().getName().equals("Constante"));

        }
        return (prioriteGauche ? "(" : "") + this.getOpGauche().toStringInfixe() + (prioriteGauche ? ")" : "")
                +operateur
                +(prioriteDroit ? "(" : "") + this.getOpDroit().toStringInfixe() + (prioriteDroit ? ")" : "");
    }
}
