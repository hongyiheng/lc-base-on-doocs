class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        n = len(words)
        s = {'a', 'e', 'i', 'o', 'u'}
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + (1 if words[i][0] in s and words[i][-1] in s else 0)
        ans = []
        for x, y in queries:
            ans.append(pre[y + 1] - pre[x])
        return ans
