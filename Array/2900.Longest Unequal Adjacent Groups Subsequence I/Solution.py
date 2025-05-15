class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        def f(t):
            ans = []
            for a, b in zip(words, groups):
                if b == t:
                    ans.append(a)
                    t ^= 1
            return ans

        ans1, ans2 = f(0), f(1)
        return ans1 if len(ans1) > len(ans2) else ans2
