class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        n, m = len(people), len(req_skills)
        sid = {s: i for i, s in enumerate(req_skills)}
        mask = [0] * n
        for i, skill in enumerate(people):
            for s in skill:
                mask[i] |= 1 << sid[s]
        f = [(1 << n) - 1] * (1 << m)
        f[0] = 0
        for i in range((1 << m) - 1):
            if f[i] == (1 << n) - 1:
                continue
            for j, msk in enumerate(mask):
                if f[i].bit_count() + 1 < f[i | msk].bit_count():
                    f[i | msk] = f[i] | (1 << j)
        ans = f[-1]
        return [i for i in range(n) if (ans >> i) & 1]
