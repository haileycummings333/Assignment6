import java.util.*;

class Election {
    private Map<String, Integer> votes;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    public Election() {
        votes = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    }

    public void initializeCandidates(LinkedList<String> candidates) {
        for (String candidate : candidates) {
            votes.put(candidate, 0);
        }
    }

    public void castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
        }
        updateHeap();
    }

    public void castRandomVote() {
        Random rand = new Random();
        List<String> candidateList = new ArrayList<>(votes.keySet());
        String randomCandidate = candidateList.get(rand.nextInt(candidateList.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate) {
        int totalVotes = votes.size();
        for (String c : votes.keySet()) {
            if (!c.equals(candidate)) {
                votes.put(c, 0);
            }
        }
        votes.put(candidate, totalVotes);
        updateHeap();
    }

    public List<String> getTopKCandidates(int k) {
        List<String> topCandidates = new ArrayList<>();
        while (!maxHeap.isEmpty() && k > 0) {
            topCandidates.add(maxHeap.poll().getKey());
            k--;
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
        maxHeap.addAll(votes.entrySet());
    }
}

class ElectionSystem {
    private Election election;

    public ElectionSystem() {
        election = new Election();
    }

    public void initializeElection(LinkedList<String> candidates, int p) {
        election.initializeCandidates(candidates);
    }

    public void castVotes(int p) {
        for (int i = 0; i < p; i++) {
            election.castRandomVote();
        }
    }

    public void rigElection(String candidate) {
        election.rigElection(candidate);
    }

    public List<String> getTopKCandidates(int k) {
        return election.getTopKCandidates(k);
    }

    public void auditElection() {
        election.auditElection();
    }
}

