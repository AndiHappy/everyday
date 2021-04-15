package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode049 {

    //Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
//Output: [[""]]
// Example 3:
// Input: strs = ["a"]
//Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.
//
// Related Topics Hash Table String

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List a :
                result) {
            System.out.println(a.toString());
            System.out.println("------------------");
        }
    }
    public static  List<List<String>> groupAnagrams(String[] strs) {
        if( null == strs || strs.length == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> judge = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String v = strs[i];
            char[] vvchar = v.toCharArray();
            Arrays.sort(vvchar);
            String vv = new String(vvchar);
            List<String> tmpString =  judge.getOrDefault(vv,new ArrayList<>());
            tmpString.add(v);
            judge.put(vv,tmpString);
        }
        result.addAll(judge.values());
        return result;
    }
}
