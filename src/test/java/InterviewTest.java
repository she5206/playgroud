import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InterviewTest {
    @Test
    public void group() {
        List<String> s = Arrays.asList("aab", "aba", "baa", "aaa", "abb", "bab");
        Interview interview = new Interview();
        Map<String, List<String>> resultMap = interview.group(s);
        Map<String, List<String>> ansMap = new HashMap<String, List<String>>();
        ansMap.put("30000000000000000000000000", Arrays.asList("aaa"));
        ansMap.put("12000000000000000000000000", Arrays.asList("abb", "bab"));
        ansMap.put("21000000000000000000000000", Arrays.asList("aba", "aab", "baa"));
        assertEquals(resultMap, ansMap);
    }

    @Test
    public void group2() {
        List<String> s = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Interview interview = new Interview();
        Map<String, List<String>> resultMap = interview.group(s);
        Map<String, List<String>> ansMap = new HashMap<String, List<String>>();
        ansMap.put("11000000000000000001000000", Arrays.asList("bat"));
        ansMap.put("10000000000001000001000000", Arrays.asList("tan", "nat"));
        ansMap.put("10001000000000000001000000", Arrays.asList("tea", "ate", "eat"));
        assertEquals(resultMap, ansMap);
    }
}
