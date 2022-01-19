# """
# This is FontInfo's API interface.
# You should not implement it, or speculate about its implementation
# """
#class FontInfo(object):
#    Return the width of char ch when fontSize is used.
#    def getWidth(self, fontSize, ch):
#        """
#        :type fontSize: int
#        :type ch: char
#        :rtype int
#        """
#
#    def getHeight(self, fontSize):
#        """
#        :type fontSize: int
#        :rtype int
#        """
class Solution:
    def maxFont(self, text: str, w: int, h: int, fonts: List[int], fontInfo : 'FontInfo') -> int:
        l, r = 0, len(fonts) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if fontInfo.getHeight(fonts[mid]) <= h:
                l = mid
            else:
                r = mid - 1
        for i in range(l, -1, -1):
            font = fonts[i]
            weight = 0
            for c in text:
                weight += fontInfo.getWidth(font, c)
                if weight > w:
                    break
            if weight <= w:
                return font
        return -1