class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int], experience: List[int]) -> int:
        ans = 0
        for v in energy:
            if v >= initialEnergy:
                d = v - initialEnergy + 1
                initialEnergy += d
                ans += d
            initialEnergy -= v

        for v in experience:
            if v >= initialExperience:
                d = v - initialExperience + 1
                initialExperience += d
                ans += d
            initialExperience += v
        return ans