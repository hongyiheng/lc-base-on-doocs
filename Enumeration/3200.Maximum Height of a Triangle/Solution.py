class Solution:
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        a = b = 0
        for i in range(1, 51):
            if i % 2:
                a += i
            else:
                b += i
            if not (a <= red and b <= blue) and not (a <= blue and b <= red):
                return i - 1
