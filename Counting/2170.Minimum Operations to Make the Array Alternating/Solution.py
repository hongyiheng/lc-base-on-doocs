class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        def get_mx_cnt(id, x):
            nonlocal n
            mp = defaultdict(int)
            for i in range(id, n, 2):
                mp[nums[i]] += 1
            mx = cnt = 0
            for k in mp.keys():
                if k != x and mp[k] > cnt:
                    mx = k
                    cnt = mp[k]
            return [mx, cnt]

        n = len(nums)
        a, a_cnt = get_mx_cnt(0, -1)
        b, b_cnt = get_mx_cnt(1, a)
        c, c_cnt = get_mx_cnt(1, -1)
        d, d_cnt = get_mx_cnt(0, c)
        return n - max(a_cnt + b_cnt, c_cnt + d_cnt)
