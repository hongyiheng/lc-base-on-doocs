class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        i = 0
        while i < len(bits) - 1:
            if bits[i] == 1:
                i = i + 2
            else:
                i = i + 1
        return i == len(bits) - 1
