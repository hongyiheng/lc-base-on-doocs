class Solution:
    def compressedString(self, word: str) -> str:
        ans = []
        cnt, cur = 0, -1
        for c in word:
            v = ord(c) - ord('a')
            if cnt >= 9:
                ans.append(str(cnt))
                ans.append(chr(cur + ord('a')))
                cnt -= 9
            if cur != v:
                if cnt:
                    ans.append(str(cnt))
                    ans.append(chr(cur + ord('a')))
                cur = v
                cnt = 1
            else:
                cnt += 1
        ans.append(str(cnt))
        ans.append(chr(cur + ord('a')))
        return "".join(ans)
