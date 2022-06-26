class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        def get_cnt(c):
            left, right, n = 0, 0, len(answerKey)
            cnt, ans = 0, 0
            while left <= right and right < n:
                if answerKey[right] != c:
                    cnt += 1
                while cnt > k:
                    if answerKey[left] != c:
                        cnt -= 1
                    left += 1
                right += 1
                ans = max(ans, right - left)
            return ans
        return max(get_cnt('F'), get_cnt('T'))