class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        s = 1
        for node in preorder.split(","):
            s -= 1
            if s < 0:
                return False
            if node != '#':
                s += 2
        return s == 0
