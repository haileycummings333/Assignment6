import java.util.*;

class Election {
    private Map<String, Integer> candidatesMap;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    public Election() {
        candidatesMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    }

    public void initializeCandidates(List<String> candidates) {
        for (String candidate : candidates) {
            candidatesMap.put(candidate, 0);
        }
    }

    public void castVote(String candidate) {
        candidatesMap.put(candidate, candidatesMap.get(candidate) + 1);
        updateHeap();
    }

    public void castRandomVote() {
        Random rand = new Random();
        List<String> candidates = new ArrayList<>(candidatesMap.keySet());
        String randomCandidate = candidates.get(rand.nextInt(candidates.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate) {
        int remainingVotes = candidatesMap.size() - candidatesMap.get(candidate);
        for (int i = 0; i < remainingVotes; i++) {
            castVote(candidate);
        }
    }

    public List<String> getTopKCandidates(int k) {
        List<String> topCandidates = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topCandidates.add(maxHeap.poll().getKey());
        }
        return topCandidates;
    }

    public void auditElection() {
        for (Map.Entry<String, Integer> entry : maxHeap) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private void updateHeap() {
        maxHeap.clear();
        maxHeap.addAll(candidatesMap.entrySet());
    }
}

class ElectionSystem {
    private Election election;

    public ElectionSystem() {
        election = new Election();
    }

    public void initialize(List<String> candidates, int p) {
        election.initializeCandidates(candidates);
    }

    public void castVotes(List<String> votes) {
        for (String vote : votes) {
            election.castVote(vote);
        }
    }

    public void castRandomVotes(int numVotes) {
        for (int i = 0; i < numVotes; i++) {
            election.castRandomVote();
        }
    }

    public void rigElection(String candidate) {
        election.rigElection(candidate);
    }

    public void printTopKCandidates(int k) {
        System.out.println("Top " + k + " candidates after " + election.getTopKCandidates(k).size() + " votes: " + election.getTopKCandidates(k));
    }

    public void printRiggedTopKCandidates(int k) {
        System.out.println("Top " + k + " candidates after rigging the election: " + election.getTopKCandidates(k));
    }

    public void auditElection() {
        election.auditElection();
    }
}

