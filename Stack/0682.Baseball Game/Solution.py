class Solution:
    def calPoints(self, ops: List[str]) -> int:
        ans = 0
        stk = []
        for o in ops:
            num = 0
            if "+" == o:
                num += stk[-2]
                num += stk[-1]
            elif "D" == o:
                num = stk[-1] * 2
            elif "C" == o:
                num = -stk.pop()
            else:
                num = int(o)
            ans += num
            if "C" != o:
                stk.append(num)
        return ans