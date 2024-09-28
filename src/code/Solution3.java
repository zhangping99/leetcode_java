package code;

import java.util.HashSet;

/**
 *
 代码
 测试用例
 测试结果
 测试结果
 3. 无重复字符的最长子串

 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。



 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


 提示：

 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成
 */



/*
滑动窗口的模板题
在左指针向右移动的时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
需要保证这两个指针对应的子串中没有重复的字符

//外层循环扩展右边界，内层循环扩展左边界
for (int l = 0, r = 0 ; r < n ; r++) {
	//当前考虑的元素
	while (l <= r && check()) {//区间[left,right]不符合题意
        //扩展左边界
    }
    //区间[left,right]符合题意，统计相关信息
}



 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>(); //用于添加子串元素，set中没有，添加且计算子串长度，set中有，不添加且删除且滑动窗口
        int result = 0;
        //外层循环拓展右边界，内层循环拓展左边界

        //每一轮右端点都扩一个
        for(int left = 0,right = 0;right<s.length();right++){
            //right指向的元素，也是当前要考虑的元素
            char current = chars[right];
            //两个指针对应的子串中没有重复的字符
            while(hashSet.contains(current)){ //hashset中有current,则缩短左边界，同时从set集合出元素
                hashSet.remove(chars[left]);//删除第一个添加的元素，因为它和最后一个添加的元素重复了
                left++;  //滑动窗口


            }
            hashSet.add(current);//将当前元素加入
            result = Math.max(result,right-left+1);
//            result = Math.max(result,hashSet.size());
        }




        return result;

    }

    public static void main(String[] args) {
        int result = new Solution3().lengthOfLongestSubstring("dvdf");
        System.out.println(result);

    }
}
