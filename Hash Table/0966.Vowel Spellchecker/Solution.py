class Node:
    def __init__(self):
        self.child = dict()
        self.origin = None


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word, origin):
        node = self.root
        for c in word:
            if c not in node.child:
                node.child[c] = Node()
            node = node.child[c]
        if not node.origin:
            node.origin = origin

    def search(self, word):
        node = self.root
        for c in word:
            if c not in node.child:
                return None
            node = node.child[c]
        return node.origin


class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        ts = [Trie(), Trie(), Trie()]
        for w in wordlist:
            ts[0].insert(w, w)
            nw = w.lower()
            ts[1].insert(nw, w)
            nw = w.lower().replace('a', '*').replace('e', '*').replace('i', '*').replace('o', '*').replace('u', '*')
            ts[2].insert(nw, w)

        ans = []
        for w in queries:
            t = ts[0].search(w)
            if t:
                ans.append(t)
                continue
            nw = w.lower()
            t = ts[1].search(nw)
            if t:
                ans.append(t)
                continue
            nw = w.lower().replace('a', '*').replace('e', '*').replace('i', '*').replace('o', '*').replace('u', '*')
            t = ts[2].search(nw)
            if t:
                ans.append(t)
                continue
            ans.append('')
        return ans
