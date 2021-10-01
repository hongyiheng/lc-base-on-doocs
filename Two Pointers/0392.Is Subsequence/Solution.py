class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        t_len = len(t)
        s_len = len(s)
        if s_len > t_len:
            return False

        left = 0;
        for i in range(s_len):
            if left == t_len:
                return False
            while s[i] != t[left]:
                left += 1
                if left == t_len:
                    return False
            left += 1
        return True