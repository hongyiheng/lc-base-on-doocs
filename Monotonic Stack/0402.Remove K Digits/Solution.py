class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stk = []
        for v in num:
            while k and stk and stk[-1] > v:
                stk.pop()
                k-= 1
            stk.append(v)
        ans = "".join(stk)
        if k:
            ans = ans[:-min(k, len(ans))]
        while ans and ans[0] == "0":
            ans = ans[1:]
        return "0" if ans == "" else ans
