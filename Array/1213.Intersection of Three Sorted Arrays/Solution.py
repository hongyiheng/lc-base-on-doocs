class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        n1, n2, n3 = len(arr1), len(arr2), len(arr3)
        idx1, idx2, idx3 = 0, 0, 0
        ans = []
        while idx1 < n1 and idx2 < n2 and idx3 < n3:
            val1, val2, val3 = arr1[idx1], arr2[idx2], arr3[idx3]
            if val1 == val2 == val3:
                ans.append(val1)
                idx1 += 1
                idx2 += 1
                idx3 += 1
            if val1 < val2 or val1 < val3:
                idx1 += 1
            if val2 < val1 or val2 < val3:
                idx2 += 1
            if val3 < val1 or val3 < val2:
                idx3 += 1
        return ans