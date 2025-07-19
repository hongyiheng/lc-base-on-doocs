class Node:
    def __init__(self):
        self.children = [None] * 27
        self.end = False

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        def find_and_save(s):
            son = False
            r = root
            for i, c in enumerate(s):
                idx = 26 if c == '/' else ord(c) - ord('a')
                if not r.children[idx]:
                    r.children[idx] = Node()
                if r.children[idx].end and s[i + 1] == '/':
                    son = True
                r = r.children[idx]
            r.end = True
            return son

        root = Node()
        folder.sort(key=lambda x: len(x))
        ans = list()
        for s in folder:
            is_son = find_and_save(s[1:])
            if not is_son:
                ans.append(s)
        return ans