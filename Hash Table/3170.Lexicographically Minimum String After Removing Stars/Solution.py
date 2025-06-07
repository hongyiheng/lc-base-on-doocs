class Solution:
    def clearStars(self, s: str) -> str:
        cnt = defaultdict(list)
        exl = set()
        d = 0
        for i, c in enumerate(list(s)):
            if c == '*':
                exl.add(i)
                d += 1
            else:
                x = ord(c) - ord('a')
                cnt[x].append(i)
            if d:
                for j in range(26):
                    if cnt[j]:
                        exl.add(cnt[j].pop())
                        break
                d -= 1
        return "".join([c for i, c in enumerate(s) if i not in exl])

