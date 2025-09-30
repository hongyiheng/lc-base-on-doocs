class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        q = nums[::]
        while len(q) > 1:
            nq = []
            for i in range(1, len(q)):
                nq.append((q[i] + q[i - 1]) % 10)
            q = nq
        return q[0]