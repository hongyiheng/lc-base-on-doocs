class Solution:
    def simplifyPath(self, path: str) -> str:
        paths, stk = path.split("/"), []
        for item in paths:
            if item == "." or item == "/" or item == "":
                continue
            if item == "..":
                if stk:
                    stk.pop(-1)
                continue
            stk.append(item)
        ans = "/".join(stk)
        return "/" + ans