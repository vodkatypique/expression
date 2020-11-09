import java.security.InvalidKeyException;
import java.util.*;

public class TestInterfaceEvaluable {
    public static void main(String[] args) throws InvalidKeyException {
        ArrayList<Evaluable> list = new ArrayList<Evaluable>();

        // création de l'environnement stockant les valeurs des variables
        Env env = new Env();
        env.associer("y", new Constante(2));
        env.associer("x", new Constante(1));
        env.associer("a", new Constante(9));
        env.associer("b", new Constante(3));

        // on ajoute quelques expressions...
        ExpAbstraite exp;

        exp = new BinaireMult(new Variable("y"), new Constante(3));
        list.add(new ExpressionEvaluable(exp, env));

        exp = new BinaireMult(new BinairePlus(new Variable("x"),
                new Variable("x")), new Constante(5));
        list.add(new ExpressionEvaluable(exp, env));

        exp = new BinaireMult(new Constante(-3.5), new UnaireSin(
                new BinairePlus(new Variable("a"), new Variable("b"))));
        list.add(new ExpressionEvaluable(exp, env));

        list.add(new ExpressionEvaluable(exp.calculerDerivee("a"), env));

        exp = new BinairePlus(
                        new UnaireSin(
                                new Variable("x")
                        ),
                        new BinaireMult(
                                new UnaireExp(
                                        new Variable("x")
                                ),
                                new BinairePow(
                                        new UnaireCos(
                                                new Variable("x")
                                        ),
                                        new Variable("x")
                                )
                        )
                );
        list.add(new ExpressionEvaluable(exp, env));
        list.add(new ExpressionEvaluable(exp.calculerDerivee("x"), env));

        // on ajoute quelques rationnels...
        list.add(new RationalEvaluable(17, 2));
        list.add(new RationalEvaluable(9));


        // affichage
        System.out.println("Ensemble des objets evaluables:");
        int i = 1;
        for (Evaluable e : list) {
            System.out.println(i++ + ". " + e
                    + "\t --> evaluation: " + e.evaluer());
        }
        System.out.println("");

        // recherche du minimum
        Evaluable min = rechercherMin(list);
        if (min != null) {
            System.out.println("L'objet d'evaluation minimale est: " + min);
            System.out.println("Sa valeur double est: " + min.evaluer());
        }
    }

    private static Evaluable rechercherMin(ArrayList<Evaluable> list) throws InvalidKeyException {
        if (list.isEmpty()) {
            return null;
        }

        Evaluable min = list.get(0);
        for (Evaluable e : list) {
            if (e.evaluer() < min.evaluer()) {
                min = e;
            }
        }
        return min;
    }

}