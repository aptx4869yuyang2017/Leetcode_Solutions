class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        record = {}
        res = []

        for num1 in nums1:
            record[num1] = record.get(num1, 0) + 1

        for num2 in nums2:
            if record.get(num2, 0) > 0:
                res.append(num2)
                record[num2] -= 1

        return res

if __name__ == '__main__':

    solution = Solution()
    nums1 = [1, 2, 2, 3]
    nums2 = [2, 2, 3, 3, 4]

    res = solution.intersect(nums1, nums2)
    print(res)
