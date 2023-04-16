class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        cnt = [0] * 26
        for c in chars:
            cnt[ord(c) - ord('a')] += 1
        ans = 0
        for w in words:
            wc = [0] * 26
            for c in w:
                wc[ord(c) - ord('a')] += 1
            flag = True
            for a, b in zip(cnt, wc):
                if b > a:
                    flag = False
                    break
            if flag:
                ans += len(w)
        return ans