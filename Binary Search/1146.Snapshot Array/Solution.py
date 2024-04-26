class SnapshotArray:

    def __init__(self, length: int):
        self.g = defaultdict(list)
        self.ver = 0

    def set(self, index: int, val: int) -> None:
        self.g[index].append((self.ver, val))

    def snap(self) -> int:
        ver = self.ver
        self.ver += 1
        return ver

    def get(self, index: int, snap_id: int) -> int:
        q = self.g.get(index, list())
        if not q:
            return 0
        l, r = 0, len(q) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if q[mid][0] > snap_id:
                r = mid - 1
            else:
                l = mid
        return 0 if q[r][0] > snap_id else q[r][1]


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)