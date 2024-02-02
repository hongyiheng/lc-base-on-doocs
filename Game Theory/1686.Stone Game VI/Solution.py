class Solution:
    def stoneGameVI(self, aliceValues: List[int], bobValues: List[int]) -> int:
        q = [(a + b, i) for i, (a, b) in enumerate(zip(aliceValues, bobValues))]
        q.sort(reverse=True)
        a = sum([aliceValues[v[1]] for i, v in enumerate(q) if not i % 2])
        b = sum([bobValues[v[1]] for i, v in enumerate(q) if i % 2])
        if a == b:
            return 0
        return 1 if a > b else -1