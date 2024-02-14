class Solution:
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        processorTime.sort()
        tasks.sort(reverse=True)
        ans = 0
        for i, v in enumerate(processorTime):
            t = tasks[i * 4]
            ans = max(ans, v + t)
        return ans
