/* 
日期：2021-03-12
53. 最大子序和
*/

/*
算法思想：贪心
原理：若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
时间复杂度：O(n)
空间复杂度：O(n)
*/

class Solution1() {
	public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int maxSubArray = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            //sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
            sum = Math.max(sum,0);
            sum += nums[i];
            //maxSubArray始终取最大值
            maxSubArray = Math.max(sum,maxSubArray);
        }
        return maxSubArray;
	}
}

/*
算法思想：动态规划
原理：若前一个元素大于0，则将其加到当前元素上
时间复杂度：O(n)
空间复杂度：O(1)
*/

class Solution2() {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

/*
算法思想：分治算法
原理：
时间复杂度：O()
空间复杂度：O()
*/

class Solution3() {
}



