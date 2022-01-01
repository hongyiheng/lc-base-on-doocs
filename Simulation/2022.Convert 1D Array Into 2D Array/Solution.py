class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        return [original[i * n:i * n + n] for i in range(m)] if len(original) == m * n else []