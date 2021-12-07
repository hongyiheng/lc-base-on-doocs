class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        arr = [0] * 26
        for i in range(len(magazine)):
            index = ord(magazine[i]) - ord('a')
            arr[index] += 1
        for i in range(len(ransomNote)):
            index = ord(ransomNote[i]) - ord('a')
            if arr[index] < 1:
                return False
            arr[index] -= 1
        return True