class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        mp = dict()
        for item in knowledge:
            mp[item[0]] = item[1]
        ans, key = "", ""
        flag = False
        for c in s:
            if c == "(":
                flag = True
                continue
            elif c == ")":
                flag = False
                ans += mp.get(key, "?")
                key = ""
                continue
            if flag:
                key += c
            else:
                ans += c
        return ans