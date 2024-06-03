class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        i, t = 0, 1
        ans = [0] * num_people
        while candies:
            v = min(t, candies)
            ans[i % num_people] += v
            candies -= v
            t += 1
            i += 1
        return ans
