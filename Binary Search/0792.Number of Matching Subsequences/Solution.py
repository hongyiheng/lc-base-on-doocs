class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        def find(i, ss):
            left, right = 0, len(ss)
            while left < right:
                mid = (left + right) >> 1
                if ss[mid] <= i:
                    left = mid + 1
                else:
                    right = mid
            return left

        mp = dict()
        for i, c in enumerate(s):
            ids = mp.get(c, list())
            ids.append(i)
            mp[c] = ids
        ans = 0
        for w in words:
            flag = True
            cur = -1
            for i, c in enumerate(w):
                ss = mp.get(c, list())
                t = find(cur, ss)
                if t == len(ss):
                    flag = False
                    break
                cur = ss[t]
            if flag:
                ans += 1
        return ans
