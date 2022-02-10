class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)

        ans = []
        for i in range(2, n + 1):
            for j in range(1, i):
                if gcd(i, j) == 1:
                    ans.append(str(j) + "/" + str(i))
        return ans