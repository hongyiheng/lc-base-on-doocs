class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        def gcd(a, b):
            return a if b == 0 else gcd(b, a % b)

        cnt = Counter(deck)
        x = 0
        for v in cnt.values():
            x = gcd(v, x)
            if x == 1:
                return False
        return x >= 2
