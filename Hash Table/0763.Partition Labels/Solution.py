class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        def check(cnt, cs):
            for c in cs:
                if cnt[ord(c) - ord('a')] != 0:
                    return False
            return True

        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        cs, ans = set(), list()
        cur = 0
        for i, v in enumerate(s):
            cnt[ord(v) - ord('a')] -= 1
            cs.add(v)
            if cnt[ord(v) - ord('a')] == 0 and check(cnt, cs):
                ans.append(i - cur + 1)
                cur = i + 1
                cs.clear()
        return ans

