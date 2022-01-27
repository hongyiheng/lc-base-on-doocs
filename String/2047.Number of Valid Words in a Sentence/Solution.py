class Solution:
    def countValidWords(self, sentence: str) -> int:
        def check(w):
            if ' ' == w or len(w) == 0:
                return False
            link = -1
            for i, c in enumerate(w):
                if 'a' <= c <= 'z':
                    continue
                elif '0' <= c <= '9':
                    return False
                elif c == '-':
                    if link == -1:
                        link = i
                    else:
                        return False
                else:
                    if i != len(w) - 1:
                        return False
            if link != -1:
                if link - 1 >= 0 and link + 1 < len(w) and 'a' <= w[link + 1] <= 'z' and 'a' <= w[link - 1] <= 'z':
                    return True
                else:
                    return False
            return True

        ans = 0
        for w in sentence.split(" "):
            if check(w):
                ans += 1
        return ans