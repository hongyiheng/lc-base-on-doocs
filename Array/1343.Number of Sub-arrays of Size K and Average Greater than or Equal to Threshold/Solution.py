class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        cur = sum(arr[:k])
        ans = 1 if cur / k >= threshold else 0
        for i in range(k, len(arr)):
            cur -= arr[i - k]
            cur += arr[i]
            if cur / k >= threshold:
                ans += 1
        return ans