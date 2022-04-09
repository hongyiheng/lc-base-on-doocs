# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        node = ListNode()
        ans = node

        def dfs(head):
            nonlocal node
            if not head:
                return
            if head.next:
                dfs(head.next)
            node.next = ListNode(head.val)
            node = node.next

        dfs(head)
        return ans.next
