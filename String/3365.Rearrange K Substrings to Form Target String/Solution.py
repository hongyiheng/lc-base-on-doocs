class Node:
    def __init__(self):
        self.children = [None] * 26
        self.cnt = 0

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]
        head.cnt += 1

    def search(self, word: str) -> bool:
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
        if head.cnt:
            head.cnt -= 1
            return True
        return False
        

class Solution:
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        n = len(s)
        tr = Trie()
        d = n // k
        for i in range(k):
            w = s[i * d: (i + 1) * d]
            tr.insert(w)
        for i in range(k):
            w = t[i * d: (i + 1) * d]
            if not tr.search(w):
                return False
        return True