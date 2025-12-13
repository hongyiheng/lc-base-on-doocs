class Solution:
    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        def check_code(s):
            for c in list(s):
                if 'a' <= c <= 'z':
                    continue
                if 'A' <= c <= 'Z':
                    continue
                if '0' <= c <= '9':
                    continue
                if c == '_':
                    continue
                return False
            return True

        ans = []
        for v, b, a in zip(code, businessLine, isActive):
            if not a or not v:
                continue
            if b not in {'electronics', 'grocery', 'pharmacy', 'restaurant'}:
                continue
            if not check_code(v):
                continue
            ans.append([v, ord(b[0])])
        ans.sort(key=lambda x: (x[1], x[0]))
        return [v for v, _ in ans]
