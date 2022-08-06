class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        n = len(words)
        ans = []
        used = [False] * n
        for i in range(n):
            for j in range(n):
                if i == j or used[j]:
                    continue
                if words[i].__contains__(words[j]):
                    ans.append(words[j])
                    used[j] = True
        return ans