class Solution:
    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        if len(arr1) < len(arr2):
            return self.addNegabinary(arr2, arr1)
        arr1 = [0, 0, 0] + arr1
        m, n = len(arr1), len(arr2)
        i = 0
        ans = []
        carry = 0
        while i < m or i < n:
            v = carry
            carry = 0
            v += arr1[m - i - 1] if i < m else 0
            v += arr2[n - i - 1] if i < n else 0
            if v >= 2:
                v -= 2
                carry = -1
            if v == -1:
                v = 1
                arr1[m - i - 2] += 1
            ans.append(v)
            i += 1
        while len(ans) > 1 and ans[-1] == 0:
            ans.pop()
        return ans[::-1]
