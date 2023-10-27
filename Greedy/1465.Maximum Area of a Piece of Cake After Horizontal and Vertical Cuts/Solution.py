class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.extend([0, h])
        verticalCuts.extend([0, w])
        horizontalCuts.sort()
        verticalCuts.sort()
        mw = mh = 0
        for i in range(len(verticalCuts) - 1):
            mw = max(mw, verticalCuts[i + 1] - verticalCuts[i])
        for i in range(len(horizontalCuts) - 1):
            mh = max(mh, horizontalCuts[i + 1] - horizontalCuts[i])
        return mw * mh % int(1e9 + 7)