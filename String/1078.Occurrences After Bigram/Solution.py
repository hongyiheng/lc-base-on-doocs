class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        sec, fst, res, words = '', '', [], text.split()
        for word in words:
            if sec == second and fst == first:
                res.append(word)
            sec, fst = word, sec
        return res
