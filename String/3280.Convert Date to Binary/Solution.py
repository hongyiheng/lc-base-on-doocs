class Solution:
    def convertDateToBinary(self, date: str) -> str:
        ans = []
        for v in date.split("-"):
            s = ""
            t = 0
            for i in range(13):
                if t == int(v):
                    break
                if int(v) >> i & 1:
                    s = "1" + s
                    t += 1 << i
                else:
                    s = "0" + s
            ans.append(s)
        return "-".join(ans)
