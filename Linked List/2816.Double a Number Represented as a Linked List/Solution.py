# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def dfs(head):
            if not head:
                return None
            up = dfs(head.next)
            v = head.val * 2 + 1 if up else head.val * 2
            head.val = v % 10
            return v >= 10

        up = dfs(head)
        return ListNode(1, head) if up else head
