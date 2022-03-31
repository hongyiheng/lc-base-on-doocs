class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def check(num):
            tmp = num
            while tmp:
                v = tmp % 10
                if v == 0:
                    return False
                if num % v == 0:
                    tmp //= 10
                else:
                    return False
            return True

        ans = []
        for i in range(left, right + 1):
            if check(i):
                ans.append(i)
        return ans