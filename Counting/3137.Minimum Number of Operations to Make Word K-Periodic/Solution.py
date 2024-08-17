class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        cnt = defaultdict(int)
        for i in range(0, len(word), k):
            s = word[i: i + k]
            cnt[s] += 1
        mx = max(cnt.values())
        return len(word) // k - mx