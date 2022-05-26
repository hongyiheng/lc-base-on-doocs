class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        head = self.root
        for c in word:
            if not head.childrens[ord(c) - ord('a')]:
                head.childrens[ord(c) - ord('a')] = Node()
            head = head.childrens[ord(c) - ord('a')]
        head.is_word = True

    def search(self, word: str) -> bool:
        head = self.root
        for c in word:
            if not head.childrens[ord(c) - ord('a')]:
                return False
            head = head.childrens[ord(c) - ord('a')]
        return head.is_word


    def startsWith(self, prefix: str) -> bool:
        head = self.root
        for c in prefix:
            if not head.childrens[ord(c) - ord('a')]:
                return False
            head = head.childrens[ord(c) - ord('a')]
        return True

class Node:
    def __init__(self):
        self.childrens = [None] * 26
        self.is_word = False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)