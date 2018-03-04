class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        height = len(triangle)

        miniPath = triangle[-1]

        for i in xrange(height-2, -1, -1):

            for j in xrange(0, len(triangle[i])):
                miniPath[j] = min(miniPath[j], miniPath[j+1]) + triangle[i][j]

        return miniPath[0]


if __name__ == '__main__':
    solution = Solution()
    testList = [[1], [2, 3], [4, 5, 6]]

    print solution.minimumTotal(testList)