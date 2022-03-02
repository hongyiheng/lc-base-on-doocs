class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        mp = dict()
        mp['9'] = '6'
        mp['6'] = '9'
        mp['8'] = '8'
        mp['1'] = '1'
        mp['0'] = '0'
        l, r = 0, len(num) - 1
        while l <= r:
            if mp.get(num[l], 'a') != num[r] or mp.get(num[r], 'b') != num[l]:
                return False
            l += 1
            r -= 1
        return True