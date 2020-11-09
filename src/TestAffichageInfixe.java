import java.security.InvalidKeyException;

public class TestAffichageInfixe {

    public static void main(String[] args) throws InvalidKeyException {
	ExpAbstraite exp;

	exp = new BinaireMult(new Variable("y"), new Constante(3));
	System.out.println(exp.toStringInfixe());

	exp = new BinaireMult(
			new BinairePlus(
					new Variable("x"),
					new Variable("x")
			),
			new Constante(5)
	);
	System.out.println(exp.toStringInfixe());

		exp = new BinaireMult(
				new Constante(-3.5),
				new UnaireSin(
						new BinairePlus(
								new Variable("a"),
								new Variable("b")
						)
				)
		);
		System.out.println(exp.toString());
		Env env = new Env();
		env.associer("a", new Constante(0));
		env.associer("b", new Constante(1));
		System.out.println(exp.evaluer(env));

		exp = new BinaireMult(
				new Variable("x"),
				new UnaireCos(
						new BinairePlus(
								new Variable("x"),
								new Variable("y")
						)
				)
		);
		System.out.println(exp.toString());
		System.out.println(exp.calculerDerivee("x"));
    }
}
