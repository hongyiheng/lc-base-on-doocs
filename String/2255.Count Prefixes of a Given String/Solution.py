class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        tr = Trie()
        tr.insert(s)
        ans = 0
        for w in words:
            if tr.start_with(w):
                ans += 1
        return ans


class Node:
    def __init__(self):
        self.children = [None] * 26

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]

    def start_with(self, prefix):
        head = self.root
        for c in prefix:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
        return True
