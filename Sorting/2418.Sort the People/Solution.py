class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        q = [[-h, n] for h, n in zip(heights, names)]
        q.sort()
        return [n for _, n in q]
