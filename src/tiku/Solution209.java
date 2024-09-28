package tiku;

/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的
子数组
 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
 */
public class Solution209 {
    //超时
//    public int minSubArrayLen(int target, int[] nums) {
//        int result = nums.length+1;//result：结果， 不可能是初始化的这个数，如果最后是，说明result = 0
//        for(int left = 0;left<nums.length;left++){
//            int sum = 0;
//            for(int right = left;right<nums.length;right++){
//                sum+=nums[right];
//                if(sum>=target){
//                    result = Math.min(result,right-left+1);
//                    break;
//                }
//            }
//        }
//        if (result == nums.length+1) result = 0;
//        return result;
//    }


//        public int minSubArrayLen(int target, int[] nums) {
//        int result = nums.length+1;//result：结果， 不可能是初始化的这个数，如果最后是，说明result = 0
//
//
//        int sum = 0;
//
//        for(int left = 0 ,right = 0;left<nums.length;left++){
//            if(left == 0) sum = nums[0];
//            else sum-= nums[left-1]; //左指针往后移一位，子数组减少一位，sum减少
//            int flag = 0;//右指针是否后移了
////            System.out.println("000left:"+left+"right:"+right+"sum:"+sum);
//            while(right<nums.length){
//                if(flag==1){
//                    sum+=nums[right]; //右指针往后移一位，子数组增加一位，sum增加
//                }
//
//                System.out.println("111left:"+left+"right:"+right+"sum:"+sum);
//
//                if (sum>=target){
//                    result = Math.min(result,right-left+1);
//
//                    break; //左指针左移，删除子数组最左侧元素
//
//                }else {
//
//
//                    right++;
//                    flag = 1;
//
//
//
//                }
////                System.out.println("222left:"+left+"right:"+right+"sum:"+sum);
//
//
//            }
//
//            if(right==nums.length+1){
//                //right循环一遍后仍然不符合条件 ，说明从left到nums.length的数字叠加都不会超过target,不用再继续叠加left了
//                break;
//            }
//
//
//
//
//
//
//
//
//
//
//        }
//        if (result == nums.length+1) result = 0;
//        return result;
//
//    }
//    public int minSubArrayLen(int target, int[] nums) {
//        int len = 1;//result：结果， 不可能是初始化的这个数，如果最后是，说明result = 0
//
//
//
//        for(int left = 0;left<nums.length;left++){
//            int sum = 0;
//            for(int right = left;right<nums.length;right++){
//                sum+=nums[right];
////                System.out.println("sum:"+sum);
//                if(sum>=target){
////                    System.out.println(left);
////                    System.out.println(right);
//                    result = Math.min(result,right-left+1);
//
//                    break;
//                }
//            }
//
//
//
//
//
//
//        }
//        if (result == nums.length+1) result = 0;
//        return result;
//
//    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length+1; //因为是求最小，初始时给个最大值,最后如果还是这个值，则result=0
        int sum = 0;
        for(int left = 0,right = 0;right<nums.length;right++){
            sum+=nums[right];//right后移，子数组长度增加，sum叠加新元素
            while (sum>=target){
                System.out.println("left:"+left+"right:"+right+"sum:"+sum);
                result = Math.min(result,right-left+1);
                //left后移，子数组长度减少，sum减去最左侧元素
                sum-=nums[left];
                left++;

            }
        }
        if(result==nums.length+1) result = 0;
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1,1,1,1};
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,4,4};
        int i = new Solution209().minSubArrayLen(4, nums);
        System.out.println(i);
    }
}
