class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        type_set = set(candyType)
        n = len(candyType) // 2
        return n if len(type_set) > n else len(type_set)