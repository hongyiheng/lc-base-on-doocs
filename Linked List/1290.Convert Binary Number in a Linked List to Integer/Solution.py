# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        def dfs(head):
            nonlocal ans
            if not head:
                return 0
            d = dfs(head.next)
            ans = ans | (head.val << d)
            return d + 1

        ans = 0
        dfs(head)
        return ans