class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        ans, cnt = [], [0] * 10
        for v in digits:
            cnt[v] += 1
        for i in range(100, 1000):
            if i % 2 == 0:
                tmp = [0] * 10
                cur = i
                while cur:
                    tmp[cur % 10] += 1
                    cur //= 10
                is_even = True
                for j in range(10):
                    if cnt[j] < tmp[j]:
                        is_even = False
                if is_even:
                    ans.append(i)
        return ans