class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        n = len(trainers)
        i = ans = 0
        for v in players:
            while i < n and v > trainers[i]:
                i += 1
            if i >= n:
                break
            ans += 1
            i += 1
        return ans
