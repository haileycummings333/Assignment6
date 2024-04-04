import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            List<String> candidates = Arrays.asList("Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud");

            int p = 5;

            ElectionSystem electionSystem = new ElectionSystem();

            electionSystem.initialize(candidates, p);

            electionSystem.castVotes(Arrays.asList("Cole Train", "Cole Train", "Marcus Fenix", "Anya Stroud", "Anya Stroud"));

            electionSystem.printTopKCandidates(p);

            electionSystem.rigElection("Marcus Fenix");

            electionSystem.printRiggedTopKCandidates(p);

            electionSystem.auditElection();

    }
}