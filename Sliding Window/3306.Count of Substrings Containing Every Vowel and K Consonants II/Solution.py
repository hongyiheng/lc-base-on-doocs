class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        def f(k):
            vowel = defaultdict(int)
            ans = cnt = l = 0
            for c in word:
                if c in 'aeiou':
                    vowel[c] += 1
                else:
                    cnt += 1
                while len(vowel) == 5 and cnt >= k:
                    t = word[l]
                    if t in 'aeiou':
                        vowel[t] -= 1
                        if vowel[t] == 0:
                            vowel.pop(t)
                    else:
                        cnt -= 1
                    l += 1
                ans += l
            return ans

        return f(k) - f(k + 1)
