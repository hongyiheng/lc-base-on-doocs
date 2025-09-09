def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
    d = [0] * (n + 1010)
    cnt = [0] * (n + 1010)
    cnt[1] = 1
    for i in range(1, n + 1):
        if cnt[i]:
            d[i] += cnt[i]
            d[i + forget] -= cnt[i]
            infect = i + delay
            while infect < i + forget:
                cnt[infect] += cnt[i]
                infect += 1
    mod = int(1e9 + 7)
    return sum(d[:n + 1]) % mod