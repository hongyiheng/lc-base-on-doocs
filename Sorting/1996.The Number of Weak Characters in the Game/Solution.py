class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda x: (-x[0], x[1]))
        ans, maxDefense = 0, -1
        for v in properties:
            if maxDefense > v[1]:
                ans += 1
            else:
                maxDefense = v[1]
        return ans