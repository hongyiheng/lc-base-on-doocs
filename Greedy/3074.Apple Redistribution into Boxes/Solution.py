class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        s = sum(apple)
        capacity.sort(reverse=True)
        for i, v in enumerate(capacity):
            s -= v
            if s <= 0:
                return i + 1
        return -1
