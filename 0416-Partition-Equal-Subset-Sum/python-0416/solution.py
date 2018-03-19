#conding=utf-8
#3917ms  6.46%

class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)

        if n == 0:
            return False

        nums_sum = 0
        for item in nums:
            nums_sum += item

        if nums_sum % 2 == 1:
            return False

        C = nums_sum / 2

        memo = [[False for j in range(C+1)] for i in range(n)]

        for j in range(C+1):
            memo[0][j] = False
            if j == nums[0]:
                memo[0][j] = True

        for i in range(n):
            memo[i][0] = False

        for i in range(1, n):
            for j in range(1, C+1):
                memo[i][j] = memo[i-1][j]
                if nums[i] <= j:
                    memo[i][j] = memo[i][j] or memo[i-1][j - nums[i]]

        for i in range(n):
            for j in range(C+1):
                print memo[i][j],

            print " "

        return memo[n-1][C]

if __name__ == '__main__':
    nums = [1, 5, 11, 5]

    solution = Solution()

    print solution.canPartition(nums)