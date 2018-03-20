class NumArray(object):


    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums
        self.length = len(nums)
        self.memo = self.calc_memo(nums)

    def calc_memo(self, nums):
        memo = [[0 for i in range(self.length)] for j in range(self.length)]
        for j in range(self.length):
            res = 0
            for i in range(j, self.length):
                res += nums[i]
                memo[j][i] = res

        return memo

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.memo[i][j]



        # Your NumArray object will be instantiated and called as such:
        # obj = NumArray(nums)
        # param_1 = obj.sumRange(i,j)

if __name__ == '__main__':

    nums = [1, 2, 3, 4]
    solution = NumArray(nums)
    print solution.sumRange(1, 2)