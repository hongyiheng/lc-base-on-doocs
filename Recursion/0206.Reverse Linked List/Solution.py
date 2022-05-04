# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        q = deque()

        def dfs(head):
            nonlocal q
            if not head:
                return
            q.append(head.val)
            dfs(head.next)
            head.val = q.popleft()

        dfs(head)
        return head