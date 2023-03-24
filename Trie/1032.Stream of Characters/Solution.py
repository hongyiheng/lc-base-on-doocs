class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]
        head.end = True

    def start_with(self, prefix):
        head = self.root
        for c in prefix:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
            if head.end:
                return True
        return False

class StreamChecker:

    def __init__(self, words: List[str]):
        self.s = ""
        self.tr = Trie()
        for w in words:
            self.tr.insert(w[::-1])

    def query(self, letter: str) -> bool:
        self.s += letter
        return self.tr.start_with(self.s[::-1])


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
