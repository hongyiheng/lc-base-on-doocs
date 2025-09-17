class NumberContainers:

    def __init__(self):
        self.g = defaultdict(list)
        self.q = {}

    def change(self, index: int, number: int) -> None:
        if index in self.q:
            old_num = self.q[index]
            pos_arr = self.g[old_num]
            pos = bisect_left(pos_arr, index)
            if pos < len(pos_arr) and pos_arr[pos] == index:
                pos_arr.pop(pos)
        self.q[index] = number
        insort(self.g[number], index)

    def find(self, number: int) -> int:
        if not self.g[number]:
            return -1
        return self.g[number][0]

# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)