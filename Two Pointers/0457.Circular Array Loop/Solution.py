class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        n = len(nums)

        def next(index):
            n = len(nums)
            return (index + nums[index] + n) % n

        for i in range(n):
            slow = i
            fast = next(slow)
            while nums[fast] * nums[i] > 0 and nums[next(fast)] * nums[i] > 0:
                if fast == slow:
                    if slow == next(slow):
                        break
                    return True
                slow = next(slow)
                fast = next(next(fast))
        return False