# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def dfs(node, d):
            if not node:
                return 1
            h = dfs(node.next, d + 1)
            if d == k:
                ans[0] = node
            if h == k:
                ans[1] = node
            return h + 1

        ans = [None, None]
        dfs(head, 1)
        ans[0].val, ans[1].val = ans[1].val, ans[0].val
        return head
