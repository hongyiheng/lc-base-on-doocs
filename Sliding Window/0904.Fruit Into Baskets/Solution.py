class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        type = set()

        def getLeft(r):
            cur = fruits[r]
            for l in range(r - 1, -1, -1):
                if fruits[l] != cur:
                    type.remove(fruits[l])
                    return l + 1
            return 0

        ans, l = 0, 0
        for r in range(len(fruits)):
            if fruits[r] not in type:
                if len(type) == 2:
                    l = getLeft(r - 1)
                type.add(fruits[r])
            ans = max(ans, r - l + 1)
        return ans