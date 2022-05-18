class Solution:
    def generatePossibleNextMoves(self, currentState: str) -> List[str]:
        ans = []
        for i in range(1, len(currentState)):
            if currentState[i] == '+' and currentState[i - 1] == '+':
                cur = currentState[:i - 1] + "--" + currentState[i + 1:]
                ans.append(cur)
        return ans