class Solution:
    def calculateScore(self, instructions: List[str], values: List[int]) -> int:
        n = len(instructions)
        used = set()
        ans = i = 0
        while 0 <= i < n:
            if i in used:
                break
            used.add(i)
            if instructions[i] == 'add':
                ans += values[i]
                i += 1
            else:
                i += values[i]
        return ans