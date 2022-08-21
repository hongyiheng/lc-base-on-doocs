class Node:
    def __init__(self):
        self.child = [None] * 26
        self.end = False

class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        root = Node()

        def insert(w):
            head = root
            for c in w:
                idx = ord(c) - ord('a')
                if not head.child[idx]:
                    head.child[idx] = Node()
                head = head.child[idx]
            head.end = True

        def prefix(w):
            head = root
            for c in w:
                idx = ord(c) - ord('a')
                if not head.child[idx]:
                    break
                head = head.child[idx]
            return head.end

        insert(searchWord)
        ss = sentence.split(" ")
        for i, v in enumerate(ss, 1):
            if prefix(v):
                return i
        return -1
