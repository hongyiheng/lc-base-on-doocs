class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        def find(end, k):
            cur = 0
            for i in range(end, -1, -1):
                cur += arr[i]
                if cur == k:
                    return i
            return -1

        n, cnt = len(arr), 0
        for v in arr:
            cnt += v
        ans = [-1, -1]
        if cnt % 3 != 0:
            return ans
        if cnt == 0:
            return [0, n - 1]
        k = cnt // 3
        c = find(n - 1, k)
        b = find(c - 1, k)
        a = find(b - 1, k)
        if a == -1 or b == -1 or c == -1:
            return ans
        while c < n:
            if arr[a] != arr[b] or arr[b] != arr[c]:
                return ans
            a += 1
            b += 1
            c += 1
        return [a - 1, b]
