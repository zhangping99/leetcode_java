package code;

import java.util.*;

/*
30. 串联所有单词的子串
给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。

示例 1：
输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
输出顺序无关紧要。返回 [9,0] 也是可以的。


示例 2：

输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]
解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
所以我们返回一个空数组。

示例 3：

输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]
解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。

 */
public class Solution30 {
//    public List<Integer> findSubstring(String s, String[] words) {
//        ArrayList<Integer> result = new ArrayList<>();
//        HashMap<String, Integer> map = new HashMap<>(); //k:单词，v:单词出现次数
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1); //增加单词出现次数
//        }
//        HashMap<String, Integer> map2 = new HashMap<>();  //用map2进行操作
//        map2.putAll(map);
//
//        for (int left = 0, right = left+(words[0].length()*words.length) ; right <= s.length() ;left ++,right = left+(words[0].length()*words.length)) {
//            if(right>s.length()) break;
//            //当前考虑的元素
//            String current = s.substring(left,right);
//            String s1 = String.join("", words); //字符串数组 转 字符串
//            if(current.equals(s1)){
//                result.add(left);
//                continue;
//            }
//            for (int l=0,r = l+words[0].length();r<=current.length();l=l+words[0].length(),r = r+words[0].length()){
//                String word = current.substring(l, r);
//                map2.put(word, map2.getOrDefault(word, 0) - 1); //减少单词出现次数
//                if (map2.get(word) == 0) {
//                    map2.remove(word);
//                }
//            }
//            if (map2.isEmpty()) {
//                result.add(left);
//            }
//            map2.clear();
//            map2.putAll(map);
//        }
//
//defaul
//
//        return result;
//
//
//    }

//超时 艹
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> result = new HashSet<>();

        List<String> list2 = Arrays.asList(words);
        ArrayList<String> list = new ArrayList<>(list2); //对list进行操作

        for(int left = 0,right = left+words[0].length()*words.length;right<=s.length();left ++,right =left+words[0].length()*words.length ){
            String current = s.substring(left,right);
            if (current.equals(words[0])){
                result.add(left);
            }


        }
        for (int left = 0, right = left+words[0].length() ; right <= s.length() ;left ++,right = left+words[0].length()) {
            if(right>s.length()) break;
            //当前考虑的元素
            String current = s.substring(left,right);

            int l = left,r = right;
            while(list.contains(current)){
                list.remove(current);
                if (list.size()==0){ //符合条件
                    result.add(left);
                    break;
                }

                l = l+words[0].length();
                r = r+words[0].length();
                if(r>s.length()) break;
                current = s.substring(l,r);

            }
            list =  new ArrayList<>(list2);
        }
        res.addAll(result);
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"foo","bar"};
        String s = "barfoothefoobarman";
        System.out.println(s.length());
        System.out.println(words.length);

//        String[] words = {"word","good","best","good"};
        List<Integer> list = new Solution30().findSubstring(s,words);
        System.out.println(list);
    }

}
