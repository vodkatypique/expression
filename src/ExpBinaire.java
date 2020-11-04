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
        boolean prioriteDroit = !this.getOpDroit().parenthesisIsNotNecessy();
        boolean prioriteGauche = !this.getOpGauche().parenthesisIsNotNecessy();

        return (prioriteGauche ? "(" : "") + this.getOpGauche().toStringInfixe() + (prioriteGauche ? ")" : "")
                +operateur
                +(prioriteDroit ? "(" : "") + this.getOpDroit().toStringInfixe() + (prioriteDroit ? ")" : "");
    }

}
