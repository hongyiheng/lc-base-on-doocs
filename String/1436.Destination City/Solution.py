class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        us = {u for u, _ in paths}
        for _, v in paths:
            if v not in us:
                return v


