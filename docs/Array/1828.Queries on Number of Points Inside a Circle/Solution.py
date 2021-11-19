class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        res = list()
        for i, v1 in enumerate(groupSizes):
            if v1 == -1:
                continue
            temp = list()
            for j, v2 in enumerate(groupSizes):
                if len(temp) < v1 and v2 == v1:
                    temp.append(j)
                    groupSizes[j] = -1
            res.append(temp)
        return res