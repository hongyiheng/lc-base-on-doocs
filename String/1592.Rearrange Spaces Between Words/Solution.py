class Solution:
    def reorderSpaces(self, text: str) -> str:
        ws = []
        cnt = idx = 0
        while idx < len(text):
            if text[idx] == " ":
                cnt += 1
                idx += 1
                continue
            w = ""
            while idx < len(text) and text[idx] != " ":
                w += text[idx]
                idx += 1
            ws.append(w)
        if cnt == 0:
            return text
        if len(ws) == 1:
            return ws[0] + " " * cnt
        s = " " * (cnt // (len(ws) - 1))
        return s.join(ws) + " " * ((cnt) % (len(ws) - 1))