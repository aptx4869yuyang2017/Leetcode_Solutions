#coding=utf-8

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        memos = [-1 for i in range(amount)]

        for index,memo in enumerate(memos):
            if index+1 in coins:
                memos[index] = 1

        print memos
        print amount, coins

        while memos[amount-1] == -1:
            for i in range(amount-1, -1, -1):
                memos[i] = i+1
                for j in range(len(coins)-1, -1, -1):
                    if i >= coins[j] and memos[i-coins[j]] != -1:
                        memos[i] = min(memos[i], memos[i-coins[j]])

                    print "coin:{}，memo{} {}".format(j, i, memos[i]),

                print " "

                if memos[i] == i+1:
                    memos[i] = -1

        for i in memos:
            print memos[i],

        return memos[amount-1]






if __name__ == '__main__':
    solution = Solution()

    coins = [1, 2, 5]
    amount = 11

    print solution.coinChange(coins, amount)