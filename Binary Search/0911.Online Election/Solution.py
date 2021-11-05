class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.times = times
        self.persons = persons
        n = len(persons)
        win_person, count = [0] * n, [0] * (n + 1)
        cur_max = cur_win = -1
        for i in range(n):
            count[persons[i]] += 1
            if count[persons[i]] >= cur_max:
                cur_win = persons[i]
                cur_max = count[persons[i]]
            win_person[i] = cur_win
        self.win_person = win_person

    def q(self, t: int) -> int:
        left, right = 0, len(self.times) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if self.times[mid] <= t:
                left = mid
            else:
                right = mid - 1
        return self.win_person[left]

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)