/* 
日期：2021-03-13
70. 爬楼梯
*/

/*
算法思想：递归
原理：斐波那契数列
时间复杂度：O(2ⁿ)
空间复杂度：O(n)
*/

class Solution1 {
	public class int climbStairs(int n) {
		if (n == 1){
			return 1;
		}
		if (n == 2){
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
}

/*
算法思想：记忆化递归
原理：斐波那契数列，使用数组存放每种台阶数的方法总数
时间复杂度：O(n)
空间复杂度：O(n)
*/

class Solution2 {
	public class int climbStairs(int n) {
		int memo[] = new int[n + 1];
		return climbStairsMemo[n, memo];
	}
	public int climbStairsMemo(int n, int memo[]) {
		if (memo[n] > 0) {
			return memo[n];
		}
		if (n == 1) {
			memo[n] = 1;
		} else if (n == 2) {
			memo[n] = 2;
		} else {
			memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n -2, memo);
		}
		return memo[n];
	}
}

/*
算法思想：动态规划
原理：预先存放每种高度的台阶上法，直接取值
时间复杂度：O(n)
空间复杂度：O(n)
*/

class Solution3 {
	public class int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			return dp[n];
		}
	}
}

/*
算法思想：动态规划（滚动数组）
原理：使用滚动数组减少内存使用，降低空间复杂度
时间复杂度：O(n)
空间复杂度：O(1)
*/

class Solution4 {
	public class int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int first = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			int third = second + first;
			first = second;
			second = third;
		}
		return second;
	}
}

/*
算法思想：矩阵快速幂
原理：
时间复杂度：O(log)
空间复杂度：O(1)
*/

public class Solution5 {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}

/*
算法思想：斐比那契数列通项公式
原理：
时间复杂度：O(logn)
空间复杂度：O(1)
*/

public class Solution6 {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}

/* 
通项公式部分还需继续加深理解，先补补线代
https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
*/
















