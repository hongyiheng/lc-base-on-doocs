"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        t = Node(insertVal)
        t.next = t
        if not head:
            return t
        ans = head
        max_val = min_val = head.val
        while head.next != ans:
            head = head.next
            max_val = max(max_val, head.val)
            min_val = min(min_val, head.val)
        if max_val == min_val:
            t.next = ans.next
            ans.next = t
            return ans
        while not (head.val == max_val and head.next.val == min_val):
            head = head.next
        if insertVal >= max_val or insertVal <= min_val:
            t.next = head.next
            head.next = t
        else:
            while not (head.val <= insertVal <= head.next.val):
                head = head.next
            t.next = head.next
            head.next = t
        return ans