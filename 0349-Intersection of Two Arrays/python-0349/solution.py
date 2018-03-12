#coding=utf-8


class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        set1 = set(nums1)
        set2 = set(nums2)

        return list(set1 & set2)

if __name__ == '__main__':
    solution = Solution()
    print(solution.intersection([1, 2, 3, 2], [1, 3, 4]))



