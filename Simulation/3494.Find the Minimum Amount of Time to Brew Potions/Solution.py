class Solution:
    def minTime(self, skill: List[int], mana: List[int]) -> int:
        f = [0] * len(skill)
        for m in mana:
            s = 0
            for x, last in zip(skill, f):
                if last > s:
                    s = last
                s += x * m
            f[-1] = s
            for i in range(len(skill) - 2, -1, -1):
                f[i] = f[i + 1] - skill[i + 1] * m
        return f[-1]