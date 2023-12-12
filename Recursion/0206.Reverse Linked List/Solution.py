# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def dfs(node, pre):
            if not node:
                return pre
            nx = node.next
            node.next = pre
            return dfs(nx, node)

        return dfs(head, None)