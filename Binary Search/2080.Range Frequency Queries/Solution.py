class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.g = defaultdict(list)
        for i, v in enumerate(arr):
            self.g[v].append(i)

    def query(self, left: int, right: int, value: int) -> int:
        idxs = self.g[value]
        l = bisect_left(idxs, left)
        r = bisect_left(idxs, right + 1)
        return r - l

# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)