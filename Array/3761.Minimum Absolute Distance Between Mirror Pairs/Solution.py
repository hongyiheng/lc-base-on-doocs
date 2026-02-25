class Node:
    def __init__(self):
        self.children = [None] * 10
        self.pos = None

class Tire:
    def __init__(self):
        self.root = Node()
    
    def insert(self, pos, s):
        root = self.root
        preZero = True
        for i in range(len(s) - 1, -1, -1):
            v = ord(s[i]) - ord('0')
            if preZero and v == 0:
                continue
            preZero = False
            if not root.children[v]:
                root.children[v] = Node()
            root = root.children[v]
        root.pos = pos 
    
    def search(self, s):
        root = self.root
        for i in range(len(s)):
            v = ord(s[i]) - ord('0')
            if not root.children[v]:
                return None
            root = root.children[v]
        return root.pos

class Solution:
    def minMirrorPairDistance(self, nums: List[int]) -> int:
        t = Tire()
        ans = inf
        for i, v in enumerate(nums):
            j = t.search(str(v))
            if j is not None:
                ans = min(ans, i - j)
            t.insert(i, str(v))
        return -1 if ans == inf else ans

            
        