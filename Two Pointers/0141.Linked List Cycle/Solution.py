# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        fast, low = head.next, head
        while fast != low:
            if not fast or not fast.next:
                return False
            low = low.next
            fast = fast.next.next
        return True