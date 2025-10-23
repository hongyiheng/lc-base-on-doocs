class Solution:
    def hasSameDigits(self, s: str) -> bool:
        arr = [int(v) for v in list(s)]
        while len(arr) > 2:
            nx = []
            for i in range(1, len(arr)):
                nx.append((arr[i - 1] + arr[i]) % 10)
            arr = nx
        return arr[0] == arr[1]
