import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-the-difference-of-two-arrays
public class LeetCode02215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        final Set<Integer> allNums1 = new HashSet<>();
        final Set<Integer> allNums2 = new HashSet<>();

        for(int i = 0; i < nums1.length; ++i) {
            allNums1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; ++i) {
            allNums2.add(nums2[i]);
        }

        final List<Integer> answer1 = new ArrayList<>();
        for(Integer item : allNums1) {
            if (!allNums2.contains(item)) {
                answer1.add(item);
            }
        }

        final List<Integer> answer2 = new ArrayList<>();
        for(Integer item : allNums2) {
            if (!allNums1.contains(item)) {
                answer2.add(item);
            }
        }

        final List<List<Integer>> result = new ArrayList<>();
        result.add(answer1);
        result.add(answer2);
        return result;
    }
}
