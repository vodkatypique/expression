import java.security.InvalidKeyException;

public class RationalEvaluable extends Rational implements Evaluable {
    private Rational rat;
    public RationalEvaluable(int num, int denum){
        super(num, denum);
    }
    public RationalEvaluable(int n) {
        super(n, 1);
    }

    public RationalEvaluable(Rational other) {
        super(other.getNum(), other.getDenom());
    }

    @Override
    public double evaluer() {
        return this.toDouble();
    }


}
