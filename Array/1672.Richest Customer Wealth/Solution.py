class Solution(object):
    def maximumWealth(self, accounts):
        res = 0
        for account in accounts:
            res = max(res, sum(account))
        return res
