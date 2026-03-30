import java.util.*;

public class DNFSAT {

    public static boolean termPossible(String term) {

        String[] parts = term.split("&");

        Set<String> positiveVars = new HashSet<>();
        Set<String> negativeVars = new HashSet<>();

        for (int i = 0; i < parts.length; i++) {

            String literal = parts[i].trim();

            if (literal.startsWith("~")) {

                String var = literal.substring(1);

                if (positiveVars.contains(var))
                    return false;

                negativeVars.add(var);

            } else {

                if (negativeVars.contains(literal))
                    return false;

                positiveVars.add(literal);
            }
        }

        return true;
    }

    public static boolean dnfSat(String expression) {

        String[] terms = expression.split("\\|");

        for (String t : terms) {

            t = t.replace("(", "").replace(")", "").trim();

            if (termPossible(t))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter DNF expression:");

        String expression = input.nextLine();

        if (dnfSat(expression))
            System.out.println("SATISFIABLE");
        else
            System.out.println("NOT SATISFIABLE");

        input.close();
    }
}