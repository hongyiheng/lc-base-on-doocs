class MyHashSet:

    def __init__(self):
        self.s = [False] * 1000010

    def add(self, key: int) -> None:
        self.s[key] = True

    def remove(self, key: int) -> None:
        self.s[key] = False

    def contains(self, key: int) -> bool:
        return self.s[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)