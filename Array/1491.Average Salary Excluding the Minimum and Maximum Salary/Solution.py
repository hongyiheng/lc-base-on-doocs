class Solution:
    def average(self, salary: List[int]) -> float:
        mi, mx = inf, 0
        s = 0
        for v in salary:
            if mi > v:
                mi = v
            if mx < v:
                mx = v
            s += v
        return (s - mi - mx) / (len(salary) - 2)