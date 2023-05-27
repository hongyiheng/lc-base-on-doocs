class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        m, n = len(words), len(words[0])
        ans = []
        if m * n > len(s):
            return ans
        t = defaultdict(int)
        for w in words:
            t[w] += 1

        for i in range(n):
            l = r = i
            cnt = 0
            cur = defaultdict(int)
            while r + n <= len(s):
                w = s[r:r+n]
                r += n
                if w not in t:
                    cur.clear()
                    cnt = 0
                    l = r
                    continue
                cnt += 1
                cur[w] += 1
                while cur[w] > t[w]:
                    cur[s[l:l+n]] -= 1
                    l += n
                    cnt -= 1
                if cnt == m:
                    ans.append(l)
        return ans
