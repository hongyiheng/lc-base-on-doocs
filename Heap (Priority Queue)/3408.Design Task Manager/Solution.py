class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.q = []
        self.rm = defaultdict(int)
        self.user = defaultdict(int)
        self.d = 0
        for u, t, p in tasks:
            self.add(u, t, p)

    def add(self, userId: int, taskId: int, priority: int) -> None:
        heapq.heappush(self.q, [-priority, -taskId, self.d])
        self.user[taskId] = userId
        self.d += 1

    def edit(self, taskId: int, newPriority: int) -> None:
        self.rmv(taskId)
        heapq.heappush(self.q, [-newPriority, -taskId, self.d])

    def rmv(self, taskId: int) -> None:
        self.rm[taskId] = self.d
        self.d += 1

    def execTop(self) -> int:
        if not self.q:
            return -1
        p, t, d = heapq.heappop(self.q)
        while d <= self.rm.get(-t, -1):
            if self.q:
                p, t, d = heapq.heappop(self.q)
            else:
                return -1
        return self.user[-t]



# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()