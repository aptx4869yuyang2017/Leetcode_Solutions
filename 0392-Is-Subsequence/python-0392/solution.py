

class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        ti = 0
        for subS in s:

            if ti >= len(t):
                break

            while ti < len(t):
                if subS == t[ti]:
                    ti += 1
                    break
                else:
                    ti += 1

                if ti == len(t):
                    return False

        return True

if __name__ == '__main__':
    solutin = Solution()
    print solutin.isSubsequence("abf", "abcd")