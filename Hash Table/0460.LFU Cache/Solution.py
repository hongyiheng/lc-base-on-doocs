class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.minFreq = 0
        self.kv = dict()
        self.keyFreq = dict()
        self.freqKeys = defaultdict(deque)

    def get(self, key: int) -> int:
        if key not in self.kv:
            return -1
        self.incrFreq(key)
        return self.kv[key]

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key in self.kv:
            self.incrFreq(key)
        else:
            if len(self.kv) >= self.capacity:
                delKey = self.freqKeys[self.minFreq].popleft()
                if not self.freqKeys[self.minFreq]:
                    self.freqKeys.pop(self.minFreq)
                self.kv.pop(delKey)
                self.keyFreq.pop(delKey)
            self.keyFreq[key] = 1
            self.freqKeys[1].append(key)
            self.minFreq = 1
        self.kv[key] = value

    def incrFreq(self, key):
        f = self.keyFreq.get(key)
        self.freqKeys.get(f).remove(key)
        if not self.freqKeys.get(f):
            self.freqKeys.pop(f)
            if f == self.minFreq:
                self.minFreq += 1
        self.keyFreq[key] = f + 1
        self.freqKeys[f + 1].append(key)




# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)