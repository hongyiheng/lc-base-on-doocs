class Solution:
    def minimumOperations(self, num: str) -> int:
        n = len(num)
        t = a1 = False
        ans1 = ans2 = n
        for i in range(n - 1, -1, -1):
            if not t and num[i] == '5':
                t = True
                continue
            if t and num[i] in {'2', '7'}:
                a1 = True
                break
            ans1 -= 1

        t = False
        for i in range(n - 1, -1, -1):
            if t and num[i] in {'0', '5'}:
                break
            if num[i] == '0':
                t = True
                continue
            ans2 -= 1
        return n - max(ans1, ans2) if a1 else n - ans2

