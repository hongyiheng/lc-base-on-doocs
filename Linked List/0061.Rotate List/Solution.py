# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:
            return head
        deep = 0

        def link(root):
            nonlocal head, deep
            deep += 1
            if root.next is None:
                root.next = head
                return
            link(root.next)

        link(head)
        offset = deep - k % deep
        while offset > 1:
            offset -= 1
            head = head.next
        ans = head.next
        head.next = None
        return ans
