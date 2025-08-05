class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        used = set()
        for x in fruits:
            for i, y in enumerate(baskets):
                if i not in used and y >= x:
                    used.add(i)
                    break
        return len(fruits) - len(used)