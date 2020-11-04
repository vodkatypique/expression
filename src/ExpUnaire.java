public abstract class ExpUnaire extends ExpAbstraite{
    private ExpAbstraite operande;

    protected ExpAbstraite getOperande() {
        return operande;
    }

    protected void setOperande(ExpAbstraite operande) {
        this.operande = operande;
    }
}
