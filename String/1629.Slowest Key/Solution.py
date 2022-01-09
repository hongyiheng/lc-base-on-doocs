class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        ans, max_time = keysPressed[0], releaseTimes[0]
        for i in range(1, len(releaseTimes)):
            cur_time = releaseTimes[i] - releaseTimes[i - 1]
            if max_time < cur_time:
                ans = keysPressed[i]
                max_time = cur_time
            elif max_time == cur_time and keysPressed[i] > ans:
                ans = keysPressed[i]
        return ans