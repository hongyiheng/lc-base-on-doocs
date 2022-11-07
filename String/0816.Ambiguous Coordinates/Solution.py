class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        s = s[1:-1]
        n = len(s)
        ans = set()
        for i in range(n):
            ls, rs = list(), list()
            left = s[:i + 1]
            right = s[i + 1:]
            if not left or not right:
                continue
            if len(left) == 1:
                ls.append(left)
            else:
                if left[0] == '0':
                    ls.append("0." + left[1:])
                else:
                    ls.append(left)
                    num = left[-1] != '0'
                    for j in range(len(left) - 2, -1, -1):
                        if not num:
                            if left[j] != '0':
                                num = True
                            continue
                        ls.append(left[:j + 1] + "." + left[j + 1:])
            if len(right) == 1:
                rs.append(right)
            else:
                if right[0] == '0':
                    rs.append("0." + right[1:])
                else:
                    rs.append(right)
                    num = right[-1] != '0'
                    for j in range(len(right) - 2, -1, -1):
                        if not num:
                            if right[j] != '0':
                                num = True
                            continue
                        rs.append(right[:j + 1] + "." + right[j + 1:])
            for l in ls:
                if '.' in l and l[-1] == '0':
                    continue
                for r in rs:
                    if '.' in r and r[-1] == '0':
                        continue
                    ans.add("(" + l + ", " + r + ")")
        return list(ans)
