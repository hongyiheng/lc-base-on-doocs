# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        pre = ListNode()
        pre.next = head

        def dfs(root):
            nonlocal val
            if not root or not root.next:
                return
            if root.next.val == val:
                root.next = root.next.next
                dfs(root)
            else:
                dfs(root.next)

        dfs(pre)
        return pre.next