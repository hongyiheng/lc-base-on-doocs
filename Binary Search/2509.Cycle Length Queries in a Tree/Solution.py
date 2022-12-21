class Solution:
    def cycleLengthQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        ans = list()
        for a, b in queries:
            cur = 0
            while a != b:
                if a < b:
                    a, b = b, a
                a >>= 1
                cur += 1
            ans.append(cur + 1)
        return ans
