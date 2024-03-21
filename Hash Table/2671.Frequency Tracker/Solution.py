class FrequencyTracker:

    def __init__(self):
        self.cnt = defaultdict(int)
        self.freq = defaultdict(set)

    def add(self, number: int) -> None:
        d = self.cnt.get(number, 0)
        if d:
            self.freq[d].remove(number)
        self.freq[d + 1].add(number)
        self.cnt[number] += 1

    def deleteOne(self, number: int) -> None:
        d = self.cnt.get(number, 0)
        if d:
            self.freq[d].remove(number)
            if d - 1 > 0:
                self.freq[d - 1].add(number)
            self.cnt[number] -= 1

    def hasFrequency(self, frequency: int) -> bool:
        return len(self.freq[frequency]) > 0



# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)