# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def gcd(a, b):
            return gcd(b, a % b) if b else a

        def dfs(node):
            if not node or not node.next:
                return node
            ne = node.next
            mid = ListNode(gcd(node.val, ne.val))
            node.next = mid
            mid.next = dfs(ne)
            return node

        dfs(head)
        return head
