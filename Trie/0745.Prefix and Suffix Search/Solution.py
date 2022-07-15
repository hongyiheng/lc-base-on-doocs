class WordFilter:
    def __init__(self, words: List[str]):
        self.pre = Node()
        self.tail = Node()
        self.words = words
        for i in range(len(words)):
            self.insert(i, False)
            self.insert(i, True)

    def f(self, pref: str, suff: str) -> int:
        pre_ids = self.query(pref, False)
        tail_ids = self.query(suff, True)
        i, j = len(pre_ids) - 1, len(tail_ids) - 1
        while i >= 0 and j >= 0:
            if pre_ids[i] == tail_ids[j]:
                return pre_ids[i]
            elif pre_ids[i] > tail_ids[j]:
                i -= 1
            else:
                j -= 1
        return -1

    def query(self, w, desc):
        head = self.pre
        if desc:
            head = self.tail
            w = w[::-1]
        for c in w:
            if not head.child[ord(c) - ord('a')]:
                return []
            head = head.child[ord(c) - ord('a')]
        return head.ids

    def insert(self, i, desc):
        head = self.pre
        w = self.words[i]
        if desc:
            head = self.tail
            w = w[::-1]
        for c in w:
            if not head.child[ord(c) - ord('a')]:
                head.child[ord(c) - ord('a')] = Node()
            head = head.child[ord(c) - ord('a')]
            head.ids.append(i)


class Node:
    def __init__(self):
        self.ids = []
        self.child = [None] * 26



# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(pref,suff)