class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        i = 0
        if ruleKey == 'color':
            i = 1
        elif ruleKey == 'name':
            i = 2
        ans = 0
        for s in items:
            if s[i] == ruleValue:
                ans += 1
        return ans
