class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.g = dict()


    def insert(self, key: str, val: int) -> None:
        self.g[key] = val


    def sum(self, prefix: str) -> int:
        ans = 0
        for k, v in self.g.items():
            if k.startswith(prefix):
                ans += v
        return ans


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)