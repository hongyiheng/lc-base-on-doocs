class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        arr = list()
        for i in range(len(nums)):
            if len(arr) > k:
                arr.remove(nums[i - k - 1])
            arr.append(nums[i])
            list.sort(arr)
            index = bisect.bisect_left(arr, nums[i])
            if index > 0 and abs(arr[index - 1] - arr[index]) <= t:
                return True
            if index < len(arr) - 1 and abs(arr[index + 1] - arr[index]) <= t:
                return True
        return False