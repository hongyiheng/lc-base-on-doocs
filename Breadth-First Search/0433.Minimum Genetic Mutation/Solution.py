class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        dirs = ["A", "C", "G", "T"]
        bank_set = set(bank)
        q = []
        step = 0
        q.append(start)
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.pop()
                for i in range(len(cur)):
                    for d in dirs:
                        ne = cur[:i] + d + cur[i + 1:]
                        if ne != cur and ne in bank_set:
                            if ne == end:
                                return step + 1
                            bank_set.remove(ne)
                            q.append(ne)
            step += 1
        return -1