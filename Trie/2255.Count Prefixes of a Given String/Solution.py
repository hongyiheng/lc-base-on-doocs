class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = 0


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, s):
        node = self.root
        for c in s:
            v = ord(c) - ord('a')
            if node.children[v] is None:
                node.children[v] = Node()
            node = node.children[v]
        node.end += 1

    def search(self, s):
        ans = 0
        node = self.root
        for c in s:
            v = ord(c) - ord('a')
            if node.children[v] is None:
                break
            node = node.children[v]
            ans += node.end
        return ans


class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        tr = Trie()
        for w in words:
            tr.insert(w)
        return tr.search(s)
