package com.algorithm.dynamicProgramming;


public class Subsequence {

    /**
     * 最长增长子序列(不一定连续，但顺序不能乱)
     * 设 dp[i] 表示以 i 结尾的最长递增子序列长度（注意是以i结尾），LIS表示其最长增长子序列
     * 例如序列 5 3 4 8 6 7，那么
     * d(0)=1
     * 由于5>3，所以LIS={3},d(1)=1
     * 由于3<4，所以LIS={3,4}=2,d(2)=dp(1)+1
     * 由于4<8，所以LIS={3,4,8},d(3)=dp(2)+1
     * 由于8>6，所以LIS={3,4,6},d(4)=dp(2)+1
     *
     * d(i)=Max{dp[0]-d[j]}+1,其中j<i,A[j]<=A[i]
     */
    public static int longestIncreasingSubsequence(int[] nums){
        int[] maxLength = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxLength[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<=nums[i]){
                    maxLength[i] = maxLength[i] < maxLength[j] + 1 ? maxLength[j] + 1 : maxLength[i];
                }
            }
        }
        int ret = 0;
        for (int i = 0; i <maxLength.length ; i++) {
            if(maxLength[i] > ret){
                ret = maxLength[i];
            }
        }
        return ret;
    }


}
