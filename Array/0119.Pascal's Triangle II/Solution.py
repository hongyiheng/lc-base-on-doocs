class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        q = [1] * 2
        while len(q) < rowIndex + 1:
            nq = [1] * (len(q) + 1)
            for i in range(1, len(q)):
                nq[i] = q[i - 1] + q[i]
            q = nq
        return q

        