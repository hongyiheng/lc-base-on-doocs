class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        mp = Counter(nums)

        def cmp(a, b):
            if mp[a] != mp[b]:
                return mp[a] - mp[b]
            return b - a

        nums.sort(key=cmp_to_key(cmp))
        return nums