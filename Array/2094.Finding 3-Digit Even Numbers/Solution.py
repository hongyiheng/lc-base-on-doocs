class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        s = set()
        n = len(digits)
        for i in range(n):
            if digits[i] == 0:
                continue
            for j in range(n):
                if j == i:
                    continue
                for k in range(n):
                    if k == j or k == i or digits[k] % 2:
                        continue
                    s.add(digits[i] * 100 + digits[j] * 10 + digits[k])
        return sorted(list(s))