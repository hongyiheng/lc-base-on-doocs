class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        ans, m = 0, len(requests)

        def lowbit(x):
            return x & -x

        def count(x):
            cnt = 0
            while x:
                cnt += 1
                x -= lowbit(x)
            return cnt

        def check(cnt):
            for v in cnt:
                if v != 0:
                    return False
            return True

        for i in range(1 << m):
            choose_num = count(i)
            if choose_num <= ans:
                continue
            cnt = [0] * n
            for k, v in enumerate(requests):
                if (i & (1 << k) != 0):
                    cnt[v[0]] += 1
                    cnt[v[1]] -= 1
            if check(cnt):
                ans = choose_num
        return ans


