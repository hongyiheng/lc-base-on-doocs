class Solution:
    def checkTwoChessboards(self, coordinate1: str, coordinate2: str) -> bool:
        x1, y1, x2, y2 = ord(coordinate1[0]) - ord('a'), int(coordinate1[1]), ord(coordinate2[0]) - ord('a'), int(coordinate2[1])
        if x1 % 2 == x2 % 2:
            return y1 % 2 == y2 % 2
        return y1 % 2 != y2 % 2