class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row, col, box = defaultdict(set), defaultdict(set), defaultdict(set)
        for i, r in enumerate(board):
            for j, v in enumerate(r):
                if v == '.':
                    continue
                if v in row[i]:
                    return False
                if v in col[j]:
                    return False
                if v in box[i // 3 * 3 + j // 3]:
                    return False
                row[i].add(v)
                col[j].add(v)
                box[i // 3 * 3 + j // 3].add(v)
        return True