class LockingTree:

    def __init__(self, parent: List[int]):
        self.parent = parent
        self.g = defaultdict(list)
        self.locks = [-1] * len(parent)
        self.n = len(parent)
        for i, p in enumerate(parent):
            self.g[p].append(i)

    def lock(self, num: int, user: int) -> bool:
        if self.locks[num] == -1:
            self.locks[num] = user
            return True
        return False

    def unlock(self, num: int, user: int) -> bool:
        if self.locks[num] == user:
            self.locks[num] = -1
            return True
        return False

    def upgrade(self, num: int, user: int) -> bool:
        if self.locks[num] != -1:
            return False

        p = self.parent[num]
        while p != -1:
            if self.locks[p] != -1:
                return False
            p = self.parent[p]

        cnt = 0
        q = [num]
        while q:
            u = q.pop()
            for v in self.g[u]:
                if self.locks[v] != -1:
                    self.locks[v] = -1
                    cnt += 1
                q.append(v)

        if cnt > 0:
            self.locks[num] = user
        return cnt > 0





# Your LockingTree object will be instantiated and called as such:
# obj = LockingTree(parent)
# param_1 = obj.lock(num,user)
# param_2 = obj.unlock(num,user)
# param_3 = obj.upgrade(num,user)