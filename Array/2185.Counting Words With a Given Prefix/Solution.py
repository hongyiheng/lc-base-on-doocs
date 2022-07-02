class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        def insert(root, w):
            head = root
            for c in w:
                if not head.child[ord(c) - ord('a')]:
                    head.child[ord(c) - ord('a')] = Node()
                head = head.child[ord(c) - ord('a')]

        def start_with(root, w):
            head = root
            for c in w:
                if not head.child[ord(c) - ord('a')]:
                    for i in range(26):
                        if head.child[i]:
                            return False
                    return True
                head = head.child[ord(c) - ord('a')]
            return True

        root = Node()
        insert(root, pref)
        ans = 0
        for w in words:
            if len(w) < len(pref):
                continue
            if start_with(root, w):
                ans += 1
        return ans


class Node:
    def __init__(self):
        self.child = [None] * 26