import java.util.Arrays;
import java.util.LinkedList;

public class Main {
        public static void main(String[] args) {
                ElectionSystem system = new ElectionSystem();
                LinkedList<String> candidates = new LinkedList<>(Arrays.asList("Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud"));
                int p = 5;

                system.initializeElection(candidates, p);
                system.castVotes(p);
                System.out.println("Top 3 candidates after " + p + " votes: " + system.getTopKCandidates(3));


                system.rigElection("Marcus Fenix");
                System.out.println("Top 3 candidates after rigging the election: " + system.getTopKCandidates(3));


                System.out.println("Audit of the election:");
                system.auditElection();
        }
}
