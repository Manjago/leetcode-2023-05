import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode01557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        final Set<Integer> answer = new HashSet<>();

        for(List<Integer> edge : edges) {
            answer.add(edge.get(0));
        }

        for(List<Integer> edge : edges) {
            answer.remove(edge.get(1));
        }

        return new ArrayList<>(answer);
    }
}
