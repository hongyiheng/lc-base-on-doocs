class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, s):
        cur = self.root
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            if not cur.children[idx]:
                cur.children[idx] = Node()
            cur = cur.children[idx]
        cur.end = True

    def search(self, s) -> bool:
        cur = self.root
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            if not cur.children[idx]:
                return False
            cur = cur.children[idx]
            if cur.end:
                return True
        return False


class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        tr = Trie()
        for s in forbidden:
            tr.insert(s)
        l = r = ans = 0
        while r < len(word):
            while tr.search(word[l:r + 1]):
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans



