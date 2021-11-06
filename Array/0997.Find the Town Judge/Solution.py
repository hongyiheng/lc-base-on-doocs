class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        count = [0] * (n + 1)
        not_Judge = [False] * (n + 1)
        for item in trust:
            not_Judge[item[0]] = True
            count[item[1]] += 1
        for i in range(1, len(count)):
            if count[i] == n - 1 and not not_Judge[i]:
                return i
        return -1