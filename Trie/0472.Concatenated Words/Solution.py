class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False

class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        root = Node()
        words.sort(key=lambda x:len(x))

        def insert(word):
            node = root
            for c in word:
                index = ord(c) - ord('a')
                if node.children[index] is None:
                    node.children[index] = Node()
                node = node.children[index]
            node.end = True

        def dfs(word, i):
            n = len(word)
            if i == n:
                return True
            node = root
            while i < n:
                index = ord(word[i]) - ord('a')
                if node.children[index] is None:
                    return False
                node = node.children[index]
                if node.end and dfs(word, i + 1):
                    return True
                i += 1
            return False

        ans = []
        for word in words:
            if word:
                if dfs(word, 0):
                    ans.append(word)
                else:
                    insert(word)
        return ans