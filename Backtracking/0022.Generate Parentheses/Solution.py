class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        choose = ["(", ")"]

        def backTrace(lefts, rights, temp_str, res):
            if lefts == 0 and rights == 0:
                res.append(temp_str)
            if rights < lefts:
                return
            for cur in choose:
                temp_str += cur
                if cur == "(" and lefts > 0:
                    backTrace(lefts - 1, rights, temp_str, res)
                elif cur == ")" and rights > 0:
                    backTrace(lefts, rights - 1, temp_str, res)
                temp_str = temp_str[:-1]

        res = []
        backTrace(n, n, "", res)
        return res