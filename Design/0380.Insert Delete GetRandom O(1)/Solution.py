class RandomizedSet:
    def __init__(self):
        self.mp = dict()
        self.idx = -1
        self.nums = [0] * 20010

    def insert(self, val: int) -> bool:
        if val in self.mp:
            return False
        self.idx += 1
        self.mp[val] = self.idx
        self.nums[self.idx] = val
        return True

    def remove(self, val: int) -> bool:
        if val not in self.mp:
            return False
        index = self.mp[val]
        self.mp.pop(val)
        if index != self.idx:
            self.mp[self.nums[self.idx]] = index
        self.nums[index] = self.nums[self.idx]
        self.idx -= 1
        return True


    def getRandom(self) -> int:
        return self.nums[random.randint(0, self.idx)]




# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()