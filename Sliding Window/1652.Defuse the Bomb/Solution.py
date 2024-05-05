class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        ans = [0] * n
        if not k:
            return ans
        if k > 0:
            s = sum(code[1:k + 1])
            for i in range(n):
                ans[i] = s
                s -= code[(i + 1) % n]
                s += code[(i + k + 1) % n]
        else:
            s = sum(code[n + k:])
            for i in range(n):
                ans[i] = s
                s -= code[(i + n + k) % n]
                s += code[i]
        return ans