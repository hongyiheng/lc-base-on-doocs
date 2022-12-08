class Solution:
    def squareIsWhite(self, coordinates: str) -> bool:
        r, c = ord(coordinates[0]) - ord('a'), ord(coordinates[1]) - ord('1')
        return c % 2 != 0 if r % 2 == 0 else c % 2 == 0
