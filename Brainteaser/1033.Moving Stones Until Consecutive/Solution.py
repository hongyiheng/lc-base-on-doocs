class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        arr = [a, b, c]
        arr.sort()
        gap1, gap2 = arr[1] - arr[0] - 1, arr[2] - arr[1] - 1
        if gap1 == 0 and gap2 == 0:
            return [0, gap1 + gap2]
        return [2 if gap1 > 1 and gap2 > 1 else 1, gap1 + gap2]
