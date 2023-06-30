class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        ss = sentence.split(" ")
        last = ss[-1][-1]
        for w in ss:
            if w[0] != last:
                return False
            last = w[-1]
        return True