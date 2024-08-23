# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        def dfs(node):
            if not node:
                return None
            if node.val in s:
                return dfs(node.next)
            node.next = dfs(node.next)
            return node

        s = set(nums)
        return dfs(head)