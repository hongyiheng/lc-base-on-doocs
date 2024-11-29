# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def dfs(root):
            if not root:
                return 0
            return dfs(root.next) + 1

        n = dfs(head)
        if n == 1:
            return None
        dummy = ListNode()
        dummy.next = head
        for i in range(n // 2 - 1):
            head = head.next
        if head.next:
            head.next = head.next.next
        return dummy.next