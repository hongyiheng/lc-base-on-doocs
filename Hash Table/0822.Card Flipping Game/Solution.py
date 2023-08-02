class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        cnt = [0] * 2010
        for a, b in zip(fronts, backs):
            if a == b:
                cnt[a] = -1
            cnt[a] = -1 if cnt[a] == -1 else 1
            cnt[b] = -1 if cnt[b] == -1 else 1
        for i, v in enumerate(cnt):
            if v == 1:
                return i
        return 0