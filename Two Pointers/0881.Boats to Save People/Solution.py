class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        cur, num = limit, 2
        left, right = 0, len(people) - 1
        ans = 1
        while left <= right:
            num -= 1
            if num >= 0 and cur >= people[right]:
                cur -= people[right]
                right -= 1
            elif num >= 0 and cur >= people[left]:
                cur -= people[left]
                left += 1
            else:
                cur = limit
                num = 2
                ans += 1
        return ans