class Solution:
    def sortTheStudents(self, score: List[List[int]], k: int) -> List[List[int]]:
        m = len(score)
        col = [(score[i][k], i) for i in range(m)]
        col.sort(key=lambda x:-x[0])
        return [score[i] for _, i in col]
