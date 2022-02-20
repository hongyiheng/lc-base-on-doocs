class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        n, i = len(bits), 0
        while i < n:
            if bits[i] == 1:
                i += 1
            elif bits[i] == 0 and i == n - 1:
                return True
            i += 1
        return False