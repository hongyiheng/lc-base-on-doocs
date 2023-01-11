class Solution:
    def digitCount(self, num: str) -> bool:
        cnt = [0] * 10
        for i, v in enumerate(num):
            cnt[i] += int(v)
            cnt[int(v)] -= 1
        for v in cnt:
            if v != 0:
                return False
        return True
