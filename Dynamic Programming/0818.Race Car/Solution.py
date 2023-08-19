class Solution:
    def racecar(self, target: int) -> int:
        f = [inf] * (target + 1)
        for i in range(1, target + 1):
            d = 1
            while (1 << d) - 1 < 2 * i:
                forward = (1 << d) - 1
                if forward == i:
                    f[i] = d
                elif forward > i:
                    f[i] = min(f[i], d + 1 + f[forward - i])
                else:
                    f[i] = min(f[i], d + 2 + f[i - forward])
                    b = 1
                    while (1 << b) - 1 < forward:
                        backward = (1 << b) - 1
                        f[i] = min(f[i], d + 1 + b + 1 + f[i - forward + backward])
                        b += 1
                d += 1
        return f[target]