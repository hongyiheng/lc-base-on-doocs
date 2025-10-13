class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        ans = []
        cnt = [0] * 26
        for w in words:
            cur_cnt = Counter(w)
            same = True
            for i in range(26):
                if cnt[i] != cur_cnt.get(chr(i + ord('a')), 0):
                    same = False
                cnt[i] = cur_cnt.get(chr(i + ord('a')), 0)
            if not same:
                ans.append(w)
        return ans