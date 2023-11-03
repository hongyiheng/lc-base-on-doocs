class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        n = len(arr)
        l = r = s = 0
        q = []
        while r < n:
            s += arr[r]
            while s > target:
                s -= arr[l]
                l += 1
            if s == target:
                q.append((r - l + 1, l, r))
            r += 1

        q.sort(key=lambda x: x[0])
        ans = n + 1
        for i in range(len(q)):
            for j in range(i + 1, len(q)):
                if q[i][0] + q[j][0] >= ans:
                    break
                if q[i][1] > q[j][2] or q[j][1] > q[i][2]:
                    ans = min(q[i][0] + q[j][0], ans)
                    break
        return -1 if ans > n else ans