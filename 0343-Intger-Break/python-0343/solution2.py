#coding=utf-8

# 解法一：动态规划
# 要点：两次循环的目标
# 第一层:循环是遍历 1 到 n ，记录每个数字的最大分解乘积
# 第二层：遍历分解当前数字的所有子问题，利用已经记录过的memo求解，注意要同时比较两个分解数字自身的乘积
# 时间 45ms 17.28%

class Solution(object):

    def integerBreak(self, n):
        memo = {}
        memo[1] = 1

        for i in xrange(2, n+1):
            maxProduct = 0
            for j in xrange(1, i):
                maxProduct =  self.max3((j*memo[i-j]), (j * (i-j)), maxProduct)

            memo[i] = maxProduct

        return memo[n]

    def max3(self, a, b, c):
        return max(a, max(b, c))



if __name__ == '__main__':
    solution = Solution()
    print solution.integerBreak(36)