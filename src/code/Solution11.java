package code;

/*
# 题目
11. 盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
示例 1：
![在这里插入图片描述](https://img-blog.csdnimg.cn/img_convert/861ecaafaab2e9c291adafbc6b67daa5.jpeg#pic_center)
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例 2：
输入：height = [1,1]
输出：1
 */
public class Solution11 {
//    public int maxArea(int[] height) {
//        int result = 0;
//        int l = 0; //长
//        int h = 0; //高
//        for(int left = 0;left<height.length;left++){
//            for(int right = left+1;right<height.length;right++){
//                l = right - left;
//                h = Math.min(height[left],height[right]);
//                int current = l*h;
//                result = Math.max(result,current);
//            }
//
//
//        }
//        return result;
//
//    }

public int maxArea(int[] height) {
    int result = 0;
    int left = 0,right = height.length-1; //双指针
    while (left<right){
        if(height[left]<=height[right]){ //left的值小，移动left
            result = Math.max(result,(right-left)*height[left]);
            left++;
        }else { //移动右指针
            result = Math.max(result,(right-left)*height[right]);
            right--;
        }
    }
    return result;
}

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(height));

    }
}
