class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        seats.sort()
        students.sort()
        ans = 0
        for s, t in zip(students, seats):
            ans += abs(t - s)
        return ans