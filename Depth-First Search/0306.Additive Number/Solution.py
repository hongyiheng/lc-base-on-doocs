class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)

        def dfs(index, sum, pre, count):
            if index == n:
                return count >= 3
            cur = 0
            for i in range(index, n):
                if i > index and ord(num[index]) - ord('0') == 0:
                    break
                cur = cur * 10 + ord(num[i]) - ord('0')
                if count >= 2:
                    if cur < sum:
                        continue
                    elif cur > sum:
                        break
                if dfs(i + 1, cur + pre, cur, count + 1):
                    return True
            return False

        return dfs(0, 0, 0, 0)