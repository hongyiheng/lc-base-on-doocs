class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        row, residue = 1, 0
        for c in s:
            w = widths[ord(c) - ord('a')]
            if residue + w > 100:
                row += 1
                residue = w
            else:
                residue += w
        return [row, residue]