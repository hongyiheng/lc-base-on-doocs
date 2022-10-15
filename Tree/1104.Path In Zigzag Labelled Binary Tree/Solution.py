class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        def get_p(cur, row):
            cur_min, cur_max = 1 << row, (1 << row + 1) - 1
            p_min, p_max = 1 << row - 1, (1 << row) - 1
            if row % 2 == 0:
                idx = cur_max - cur
                return p_min + idx // 2
            else:
                idx = cur - cur_min
                return p_max - idx // 2

        row = 0
        while label >= 1 << row:
            row += 1
        ans = [label]
        while label != 1:
            label = get_p(label, row - 1)
            ans.append(label)
            row -= 1
        return ans[::-1]
