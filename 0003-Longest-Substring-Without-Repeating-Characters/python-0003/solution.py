#coding=utf-8

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        posi = {}     # 记录字符的起始位置

        res = 0       # 返回的结果，最长子串大小
        start = 0     # 记录最长子串起始的位置


        for i,char in enumerate(s):

            print("begin  i:{}, char:{}, start:{}".format(i,char,start))

            if char in posi:
                res = max(res, i-start)    # 更新长度为上一次遍历的长度
                start = max(start, posi[char] + 1)    # 更新最长子串起点, 之所以用max是因为不要更新到以前记录过的字符
            posi[char] = i

            print("end   i:{}, char:{}, start:{}, res:{}".format(i, char, start, res))

        return max(res, len(s)-start)     # 最后一次未能更新进res的结果



if __name__ == '__main__':
    str1 = "abc"
    print(str1[1])


    solution = Solution()
    print(solution.lengthOfLongestSubstring("abba"))

