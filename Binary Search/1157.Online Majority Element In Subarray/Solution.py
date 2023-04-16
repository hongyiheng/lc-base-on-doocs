class MajorityChecker:

    def __init__(self, arr: List[int]):
        self.g = defaultdict(list)
        self.arr = arr
        for i, v in enumerate(arr):
            self.g[v].append(i)

    def query(self, left: int, right: int, threshold: int) -> int:
        for _ in range((right - left + 1) // threshold + 10):
            i = random.randint(left, right)
            v = self.arr[i]
            if len(self.g[v]) < threshold:
                continue
            ids = self.g[v]
            l, r = self.query_left(ids, left), self.query_right(ids, right)
            if r - l + 1 >= threshold:
                return v
        return -1

    def query_left(self, ids, x):
        l, r = 0, len(ids) - 1
        while l < r:
            mid = (l + r) >> 1
            if ids[mid] < x:
                l = mid + 1
            else:
                r = mid
        return l

    def query_right(self, ids, x):
        l, r = 0, len(ids) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if ids[mid] <= x:
                l = mid
            else:
                r = mid - 1
        return r if ids[r] <= x else -1

# Your MajorityChecker object will be instantiated and called as such:
# obj = MajorityChecker(arr)
# param_1 = obj.query(left,right,threshold)