class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        sl = SortedList()
        idx = SortedList(range(len(nums)))
        dec = 0
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1] :
                dec += 1
            sl.add((nums[i] + nums[i + 1], i))
        ans = 0
        while dec:
            ans += 1
            s, i = sl.pop(0)
            k = idx.bisect_left(i)
            nxt = idx[k + 1]
            if nums[i] > nums[nxt]:
                dec -= 1
            if k:
                pre = idx[k - 1]
                if nums[pre] > nums[i]:
                    dec -= 1
                if nums[pre] > s:
                    dec += 1
                sl.remove((nums[pre] + nums[i], pre))
                sl.add((nums[pre] + s, pre))
            if k + 2 < len(idx):
                nxt2 = idx[k + 2]
                if nums[nxt] > nums[nxt2]:
                    dec -= 1
                if s > nums[nxt2]:
                    dec += 1
                sl.remove((nums[nxt] + nums[nxt2], nxt))
                sl.add((nums[nxt2] + s, i))
            nums[i] = s
            idx.remove(nxt)
        return ans