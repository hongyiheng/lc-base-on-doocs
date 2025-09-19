class Spreadsheet:

    def __init__(self, rows: int):
        self.g = [[0] * (rows + 1) for _ in range(26)]
        
    def setCell(self, cell: str, value: int) -> None:
        self.g[ord(cell[0]) - ord('A')][int(cell[1:])] = value

    def resetCell(self, cell: str) -> None:
        self.g[ord(cell[0]) - ord('A')][int(cell[1:])] = 0

    def getValue(self, formula: str) -> int:
        a, b = formula[1:].split("+")
        av = bv = 0
        if a.isdigit():
            av = int(a)
        else:
            av = self.g[ord(a[0]) - ord('A')][int(a[1:])]
        if b.isdigit():
            bv = int(b)
        else:
            bv = self.g[ord(b[0]) - ord('A')][int(b[1:])]
        return av + bv
        

# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)