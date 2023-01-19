class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        if len(password) < 8:
            return False
        sm = bi = num = sp = False
        last = ""
        for c in password:
            if c == last:
                return False
            if 'a' <= c <= 'z':
                sm = True
            if 'A' <= c <= 'Z':
                bi = True
            if '0' <= c <= '9':
                num = True
            if c in "!@#$%^&*()-+":
                sp = True
            last = c
        return sm and bi and num and sp