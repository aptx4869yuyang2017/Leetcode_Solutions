#coding=utf-8

# 解法一：递归
# 要点：记忆化搜索
# 54ms  8.64%

class Solution(object):

    def __init__(self):
        self.memo = []

    def _breakInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        assert n > 0 and n < 59, "n is not less than 2 and not larger than 58."

        if n == 1:
            return 1

        if self.memo[n-1] != -1:
            return self.memo[n-1]

        else:
            maxProduct = -1
            # 划分为 （i, n-i) 两部分
            for i in xrange(1, n):
                maxProduct = self.max3(maxProduct, (i * (n-i)), (i * self._breakInteger(n - i)))
                self.memo[n-1] = maxProduct

            return maxProduct

    def max3(self, a, b, c):
        return max(a, max(b, c))

    def integerBreak(self, n):

        for i in xrange(n):
            self.memo.append(-1)

        return self._breakInteger(n)


if __name__ == '__main__':
    solution = Solution()
    print solution.integerBreak(36)