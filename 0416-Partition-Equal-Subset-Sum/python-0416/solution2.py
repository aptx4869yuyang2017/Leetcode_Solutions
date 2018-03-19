#conding=utf-8

# 808ms 69%

class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)

        if n < 2:
            return False

        nums_sum = sum(nums)

        if nums_sum % 2 == 1:
            return False

        C = nums_sum / 2

        memo = [False for j in range(C+1)]

        for j in range(C+1):
            if j == nums[0]:
                memo[j] = True


        for i in range(1, n):
            for j in range(C, nums[i]-1, -1):
                memo[j] = memo[j] or memo[j - nums[i]]

        return memo[C]

if __name__ == '__main__':
    nums = [1, 5, 11, 5]

    solution = Solution()

    print solution.canPartition(nums)