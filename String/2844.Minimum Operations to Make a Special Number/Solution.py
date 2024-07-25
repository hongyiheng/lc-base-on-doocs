class Solution:
    def minimumOperations(self, num: str) -> int:
        def f(t, ts):
            n = len(num)
            flag = False
            for i in range(n - 1, -1, -1):
                if flag and num[i] in ts:
                    return n - i - 2
                if num[i] == t:
                    flag = True
            if t == '0' and flag:
                return n - 1
            return n

        return min(f('0', ['0', '5']), f('5', ['2', '7']))