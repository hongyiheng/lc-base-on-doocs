from sortedcontainers import SortedList

class MKAverage:

    def __init__(self, m: int, k: int):
        self.m = m
        self.k = k
        self.nums = deque()
        self.s = 0
        self.lo = SortedList()
        self.hi = SortedList()
        self.mid = SortedList()

    def addElement(self, num: int) -> None:
        self.nums.append(num)
        if not self.lo or num <= self.lo[-1]:
            self.lo.add(num)
        elif not self.hi or num >= self.hi[0]:
            self.hi.add(num)
        else:
            self.mid.add(num)
            self.s += num

        if len(self.nums) > self.m:
            remove_num = self.nums.popleft()
            if remove_num <= self.lo[-1]:
                self.lo.remove(remove_num)
            elif remove_num >= self.hi[0]:
                self.hi.remove(remove_num)
            else:
                self.mid.remove(remove_num)
                self.s -= remove_num

        if len(self.nums) == self.m:
            while len(self.lo) > self.k:
                v = self.lo.pop()
                self.mid.add(v)
                self.s += v
            while len(self.hi) > self.k:
                v = self.hi.pop(0)
                self.mid.add(v)
                self.s += v
            while len(self.mid) > self.m - 2 * self.k:
                if len(self.lo) < self.k:
                    v = self.mid.pop(0)
                    self.lo.add(v)
                    self.s -= v
                elif len(self.hi) < self.k:
                    v = self.mid.pop()
                    self.hi.add(v)
                    self.s -= v

    def calculateMKAverage(self) -> int:
        if len(self.nums) != self.m:
            return -1
        return self.s // (self.m - 2 * self.k)
