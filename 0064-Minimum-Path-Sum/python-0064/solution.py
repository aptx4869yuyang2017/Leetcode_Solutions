class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        m = len(grid[0])

        for i in xrange(n):
            for j in xrange(m):
                if i == 0 and j == 0:
                    continue
                elif i == 0:
                    grid[i][j] += grid[i][j-1]
                elif j == 0:
                    grid[i][j] += grid[i-1][j]
                else:
                    grid[i][j] += min(grid[i-1][j], grid[i][j-1])

        return grid[-1][-1]


if __name__ == '__main__':

    grid1 = [[1, 3, 1],
             [1, 5, 1],
             [4, 2, 1]]

    solution = Solution()
    print solution.minPathSum(grid1)


