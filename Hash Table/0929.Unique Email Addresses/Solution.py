class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        ans = set()
        for s in emails:
            pre, tail = s.split("@")
            new_pre = ""
            for c in pre:
                if c == '+':
                    break
                elif c == '.':
                    continue
                else:
                    new_pre += c
            ans.add(new_pre + "@" + tail)
        return len(ans)