class Node:
    def __init__(self):
        self.child = [None] * 26
        self.val = 0

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        def insert(w):
            head = root
            for c in w:
                idx = ord(c) - ord('a')
                if not head.child[idx]:
                    head.child[idx] = Node()
                head.child[idx].val += 1
                head = head.child[idx]

        def query(w):
            ans = 0
            head = root
            for c in w:
                idx = ord(c) - ord('a')
                ans += head.child[idx].val
                head = head.child[idx]
            return ans

        root = Node()
        for w in words:
            insert(w)
        n = len(words)
        ans = [0] * n
        for i in range(n):
            ans[i] = query(words[i])
        return ans
