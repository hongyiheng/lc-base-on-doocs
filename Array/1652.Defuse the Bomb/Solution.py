class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        ans = [0] * n
        if k == 0:
            return ans
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + code[i]
        if k > 0:
            for i in range(n):
                if i + k < n:
                    ans[i] = pre[i + k + 1] - pre[i + 1]
                else:
                    ans[i] = pre[n] - pre[i + 1] + pre[(i + k + 1) % n]
        elif k < 0:
            for i in range(n):
                if i + k >= 0:
                    ans[i] = pre[i] - pre[i + k]
                else:
                    ans[i] = pre[i] + pre[n] - pre[(i + k + n) % n]
        return ans
