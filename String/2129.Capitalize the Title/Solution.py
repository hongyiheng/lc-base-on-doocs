class Solution:
    def capitalizeTitle(self, title: str) -> str:
        ws = title.split(" ")
        for i, w in enumerate(ws):
            if len(w) <= 2:
                ws[i] = w.lower()
            else:
                ws[i] = w[0].upper() + w[1:].lower()
        return " ".join(ws)
