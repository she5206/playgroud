import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Interview {

    /*
Given an array of strings, group words that have the same characters (may be in different order) together.
All inputs will be in lowercase.  The order of your output does not matter.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
  [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
  ]
Input: ["aab", "aba", "baa", "aaa", "abb", "bab"],
Output:
  [
    ["aab","aba","baa"],
    ["abb","bab"],
    ["aaa"]
  ]
*/
    private final static String AZ = "abcdefghijklmnopqrstuvwxyz";
    private final static String EMPTY = "0";

    public Map<String, List<String>> group(List<String> s) {
        Map<String, Map<String, Integer>> countMapByKey = getCountMapByKey(s);
        Map<String, List<String>> groupMap = getGroupMap(countMapByKey);
        for (Map.Entry entry : groupMap.entrySet()) {
            List<String> ans = (List<String>) entry.getValue();
            System.out.println(StringUtils.join(ans, ","));
        }
        return groupMap;
    }

    /**
     * key = "aab"
     * value = a=>2, b=1
     */
    private static Map<String, Map<String, Integer>> getCountMapByKey(List<String> s) {
        Map<String, Map<String, Integer>> countMapByKey = new HashMap();
        for (int i = 0; i < s.size(); i++) {
            Map<String, Integer> countMap = new HashMap<String, Integer>();
            for (int j = 0; j < s.get(i).length(); j++) {
                String key = String.valueOf(s.get(i).charAt(j));
                int count = countMap.containsKey(key) ? countMap.get(key) + 1 : 1;
                countMap.put(key, count);
            }
            countMapByKey.put(s.get(i), countMap);
        }
        return countMapByKey;
    }

    private static Map<String, List<String>> getGroupMap(Map<String, Map<String, Integer>> resultMap) {
        Map<String, List<String>> groupMap = new HashMap();
        for (Map.Entry entry : resultMap.entrySet()) {
            System.out.println("key=" + entry.getKey());
            Map<String, Integer> countMap = (Map<String, Integer>) entry.getValue();
            String azValue = "";
            for (int i = 0; i < AZ.length(); i++) {
                String w = String.valueOf(AZ.charAt(i));
                if (countMap.containsKey(w)) {
                    azValue += countMap.get(w);
                } else {
                    azValue += EMPTY;
                }
            }
            System.out.println("a-z value=" + azValue);
            if (groupMap.containsKey(azValue)) {
                List<String> ans = new ArrayList<String>();
                ans.addAll(groupMap.get(azValue));
                ans.add(String.valueOf(entry.getKey()));
                groupMap.put(azValue, ans);
            } else {
                groupMap.put(azValue, Arrays.asList(entry.getKey().toString()));
            }
        }
        return groupMap;
    }
}
