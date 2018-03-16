class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()

        gi = 0
        res = 0

        for i,si in enumerate(s):
            if gi >= len(g):
                break

            if si >= g[gi]:
                res += 1
                gi += 1

        return res

if __name__ == '__main__':
    solution = Solution()
    a = [1, 2]
    b = [1, 2, 3]
    print solution.findContentChildren(a, b)

