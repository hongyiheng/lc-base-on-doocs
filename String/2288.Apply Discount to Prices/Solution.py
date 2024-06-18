class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        ws = sentence.split(" ")
        for i, w in enumerate(ws):
            if w[0] == '$' and w[1:].isdigit():
                v = int(w[1:]) * (100 - discount) / 100
                ws[i] = '$' + "{:.2f}".format(v)
        return " ".join(ws)
