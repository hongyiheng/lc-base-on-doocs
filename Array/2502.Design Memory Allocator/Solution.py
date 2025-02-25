class Allocator:

    def __init__(self, n: int):
        self.m = [0] * n

    def allocate(self, size: int, mID: int) -> int:
        cnt = 0
        for i, v in enumerate(self.m):
            if v == 0:
                cnt += 1
            else:
                cnt = 0
            if cnt == size:
                for j in range(i - size + 1, i + 1):
                    self.m[j] = mID
                return i - size + 1
        return -1

    def freeMemory(self, mID: int) -> int:
        ans = 0
        for i, v in enumerate(self.m):
            if v == mID:
                self.m[i] = 0
                ans += 1
        return ans



# Your Allocator object will be instantiated and called as such:
# obj = Allocator(n)
# param_1 = obj.allocate(size,mID)
# param_2 = obj.free(mID)