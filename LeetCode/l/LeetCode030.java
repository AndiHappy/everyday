package l;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode030 {

    /***

     You are given a string s and an array of strings words of **the same length**.
     Return all starting indices of substring(s) in s
     that is a concatenation of each word in words exactly once,
     in any order, and without any intervening characters.

     You can return the answer in any order.



     Example 1:

     Input: s = "barfoothefoobarman", words = ["foo","bar"]
     Output: [0,9]
     Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
     The output order does not matter, returning [9,0] is fine too.
     Example 2:

     Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     Output: []
     Example 3:

     Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     Output: [6,9,12]


     Constraints:

     1 <= s.length <= 104
     s consists of lower-case English letters.
     1 <= words.length <= 5000
     1 <= words[i].length <= 30
     words[i] consists of lower-case English letters.

     * **/

    public List<Integer> findSubstring_copy(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words == null || words.length == 0) return res;
        int wordNum = words.length;
        int wordLen = words[0].length();
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }

        //遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words == null || words.length == 0) return result;

        // loop the words ①
        HashMap<String,Integer> wordsTimes = new HashMap<>();
        for (String word : words) {
            wordsTimes.put(word, wordsTimes.getOrDefault(word,0)+1);
        }

        int wordsNum = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < s.length() - wordLen*wordsNum +1 ; i++) {

            int itmp = i;
            HashMap<String,Integer> tmpJuge = new HashMap<>();
            while (itmp < i+ wordLen*wordsNum){
                String tmp = s.substring(itmp,itmp+wordLen);
                // ③
                if(wordsTimes.containsKey(tmp)){
                    tmpJuge.put(tmp,tmpJuge.getOrDefault(tmp,0)+1);
                    int value = tmpJuge.getOrDefault(tmp,0);
                    if(value > wordsTimes.getOrDefault(tmp,0)){
                        break;
                    }
                }else {
                    break;
                }
                itmp = itmp+ wordLen;
            }
            // ②
            if(itmp == i+ wordLen*wordsNum){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        List result = findSubstring("foofoobarfoo", new String[]{"foo","bar"});
        System.out.println(result);

        result = findSubstring("foofoobarbarfoo", new String[]{"foo","bar"});
        System.out.println(result);

        result = findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(result);

        result = findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        System.out.println(result);

        result = findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(result);


        result = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
        System.out.println(result);

//        Output: [6,9,12]

    }
}
