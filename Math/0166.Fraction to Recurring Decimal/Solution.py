class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0 or numerator / denominator == 0:
            return "0"
        ans = []
        if numerator / denominator < 0:
            ans.append("-")
        numerator, denominator = abs(numerator), abs(denominator)
        a, b = numerator, denominator
        a, b = a // b, a % b
        ans.append(str(a))
        if b:
            ans.append(".")
        g = dict()
        while b:
            b *= 10
            a, b = b // denominator, b % denominator
            ans.append(str(a))
            if b in g:
                ans.insert(g[b], "(")
                ans.append(")")
                break
            g[b] = len(ans)
        return "".join(ans)



