class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        def insert(root, w):
            head = root
            for c in w:
                if head.child[ord(c) - ord('a')] == None:
                    head.child[ord(c) - ord('a')] = Node()
                head = head.child[ord(c) - ord('a')]
            head.is_word = True

        def get_dic(root, w):
            ans = ""
            head = root
            for c in w:
                if head.is_word:
                    return ans
                if head.child[ord(c) - ord('a')] == None:
                    break
                ans += c
                head = head.child[ord(c) - ord('a')]
            return w

        root = Node()
        for w in dictionary:
            insert(root, w)
        ws = sentence.split(" ")
        for i in range(len(ws)):
            ws[i] = get_dic(root, ws[i])
        return " ".join(ws)

class Node:
    def __init__(self):
        self.child = [None] * 26
        self.is_word = False