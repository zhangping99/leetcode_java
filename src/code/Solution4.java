package code;

import java.util.*;

/*


4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Solution4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double result = 0.0;
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //自动排序 key:数组元素，value:元素出现次数，
//        for (int i : nums1) {
//            treeMap.put(i,treeMap.getOrDefault(i,0)+1);
//        }
//        for (int i : nums2) {
//            treeMap.put(i,treeMap.getOrDefault(i,0)+1);
//        }
//        int len = nums1.length+nums2.length;
//        if (len%2==0){
//            int resultIndex1 = (len-1)/2;
//            int resultIndex2 = resultIndex1+1;
//            int key1=0,key2=0;
//            int count = -1; //count = -1 :数组下标从0开始，count用来累加treemap的value,是次数 ，如果不是-1，叠加第一个元素的时候，下标就错了,理解不了自己改成0，运行代码试试
//            Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
//            while (iterator.hasNext()){
//                Map.Entry<Integer, Integer> next = iterator.next();
//                Integer key = next.getKey();
//                Integer value = next.getValue();
//                count+=value;
//                if(count>=resultIndex1) {
//                    if (count==resultIndex1){
//                        key1 = key;
//                        key2 = iterator.next().getKey();
//                    }else {
//                        key1 = key;
//                        key2 = key;
//                    }
//                    break;
//                }
//            }
//            result = (key1+key2)/2.0;
//
//        }else {
//            int resultIndex1 = (len-1)/2;
//            int key1 = 0,count = -1;
//            Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
//            while (iterator.hasNext()){
//                Map.Entry<Integer, Integer> next = iterator.next();
//                Integer key = next.getKey();
//                Integer value = next.getValue();
//                count+=value;
//                if(count>=resultIndex1) {
//                    key1 = key;
//                    break;
//                }
//            }
//            result = key1;
//        }
//
//
//
//
//
//
//
//        return result;
//
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();



        double result = 0.0;
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int len = nums1.length+nums2.length;
        if (len%2==0){
            int index = (len-1)/2;

            result = (list.get(index)+list.get(index+1))/2.0;

        }else {
            int index = (len-1)/2;
            result = list.get(index);

        }







        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(new Solution4().findMedianSortedArrays(nums1,nums2));


    }
}
