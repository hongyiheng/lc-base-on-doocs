class Solution:
    def solveEquation(self, equation: str) -> str:
        idx, n = 0, len(equation)
        left_x = right_x = 0
        left = right = 0
        cur, left_part = "", True
        while idx < n:
            if "0" <= equation[idx] <= "9":
                cur += equation[idx]
            elif equation[idx] == "x":
                if cur == "-":
                    cur = "-1"
                if left_part:
                    left_x += 1 if cur == "" else int(cur)
                else:
                    right_x += 1 if cur == "" else int(cur)
                cur = ""
            else:
                if left_part:
                    left += 0 if cur == "" else int(cur)
                else:
                    right += 0 if cur == "" else int(cur)
                cur = ""
                if equation[idx] == "=":
                    left_part = False
                if equation[idx] == "-":
                    cur = "-"
            idx += 1
        if cur:
            right += 0 if cur == "" else int(cur)
        if left_x == right_x and left == right:
            return "Infinite solutions"
        if left_part or left_x == right_x:
            return "No solution"
        return "x=" + str(int((right - left) / (left_x - right_x)))