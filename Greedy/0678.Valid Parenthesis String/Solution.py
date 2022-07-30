class Solution:
    def checkValidString(self, s: str) -> bool:
        min_ = max_ = 0
        for c in s:
            if c == "(":
                min_ += 1
                max_ += 1
            elif c == ")":
                min_ -= 1
                max_ -= 1
            else:
                min_ -= 1
                max_ += 1
            min_ = max(0, min_)
            if min_ > max_:
                return False
        return min_ == 0
