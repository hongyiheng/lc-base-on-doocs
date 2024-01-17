class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, s):
        node = self.root
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            if not node.children[idx]:
                node.children[idx] = Node()
            node = node.children[idx]
        node.end = True

    def search(self, s):
        node = self.root
        for c in s:
            idx = ord(c) - ord('a')
            if not node.children[idx]:
                return False
            node = node.children[idx]
        return node.end


class Solution:
    def maximumNumberOfStringPairs(self, words: List[str]) -> int:
        ans = 0
        tr = Trie()
        for w in words:
            if tr.search(w):
                ans += 1
            tr.insert(w)
        return ans
