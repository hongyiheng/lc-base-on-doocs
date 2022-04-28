class TimeMap:
    def __init__(self):
        self.mp = dict()
        self.ts = dict()

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.mp[key + str(timestamp)] = value
        all_ts = self.ts.get(key, [])
        all_ts.append(timestamp)
        self.ts[key] = all_ts

    def get(self, key: str, timestamp: int) -> str:
        if (key + str(timestamp)) in self.mp:
            return self.mp[key + str(timestamp)]
        if key not in self.ts:
            return ""
        all_ts = self.ts[key]
        left, right = 0, len(all_ts) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if all_ts[mid] <= timestamp:
                left = mid
            else:
                right = mid - 1
        return self.mp[key + str(all_ts[left])] if all_ts[left] <= timestamp else ""


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)