class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        pre = [0] * 2060
        for log in logs:
            pre[log[0]] += 1
            pre[log[1]] -= 1
        max_sum, cur_sum, ans = 0, 0, 0
        for i in range(len(pre)):
            cur_sum += pre[i]
            if max_sum < cur_sum:
                max_sum = cur_sum
                ans = i
        return ans