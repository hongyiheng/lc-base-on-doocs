class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        ac, vc = set(), set()
        for ps in paths:
            ac.add(ps[0])
            ac.add(ps[1])
            vc.add(ps[0])
        return [c for c in ac - vc][0]