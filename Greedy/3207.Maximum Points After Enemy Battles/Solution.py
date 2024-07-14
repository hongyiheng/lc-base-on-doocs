class Solution:
    def maximumPoints(self, enemyEnergies: List[int], currentEnergy: int) -> int:
        enemyEnergies.sort()
        if currentEnergy < enemyEnergies[0]:
            return 0
        return (currentEnergy + sum(enemyEnergies[1:])) // enemyEnergies[0]