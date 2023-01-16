class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        if len(sentence1) < len(sentence2):
            sentence1, sentence2 = sentence2, sentence1
        if sentence1 == sentence2 or sentence1.startswith(sentence2 + " ") or sentence1.endswith(" " + sentence2):
            return True
        for i in range(len(sentence2)):
            if sentence2[i] != ' ':
                continue
            if sentence1.startswith(sentence2[:i] + ' ') and sentence1.endswith(sentence2[i:]):
                return True
        return False
