class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        words = sentence.split(" ")
        for i, w in enumerate(words):
            c = w[0].lower()
            if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u':
                words[i] = w + "ma"
            else:
                words[i] = w[1:] + w[0] + "ma"
            for _ in range(i + 1):
                words[i] += "a"
        return " ".join(words)