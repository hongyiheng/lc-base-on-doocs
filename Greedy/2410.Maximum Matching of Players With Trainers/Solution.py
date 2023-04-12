class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        m, n = len(players), len(trainers)
        ans, i, j = 0, m - 1, n - 1
        while i >= 0 and j >= 0:
            if players[i] <= trainers[j]:
                ans += 1
                j -= 1
            i -= 1
        return ans
