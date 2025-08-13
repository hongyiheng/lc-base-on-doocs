class Solution:
    def isPowerOfThree(self, n: int) -> bool:
      if n <= 0:
        return False
      return not 3 ** 20 % n