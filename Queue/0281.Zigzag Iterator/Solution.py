class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.q1 = v1
        self.q2 = v2
        self.change = False

    def next(self) -> int:
        self.change = not self.change
        if self.q1:
            if self.q2:
                return self.q1.pop(0) if self.change else self.q2.pop(0)
            return self.q1.pop(0)
        return self.q2.pop(0)


    def hasNext(self) -> bool:
        return self.q1 or self.q2

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())