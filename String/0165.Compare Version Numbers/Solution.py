class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        ver_arr1 = version1.split('.')
        ver_arr2 = version2.split('.')
        m, n = len(ver_arr1), len(ver_arr2)
        for i in range(max(m, n)):
            a = int(ver_arr1[i]) if i < m else 0
            b = int(ver_arr2[i]) if i < n else 0
            if a < b:
                return -1
            elif a > b:
                return 1
        return 0