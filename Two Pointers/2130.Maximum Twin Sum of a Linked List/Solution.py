# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        q = deque()
        while head:
            q.append(head.val)
            head = head.next
        ans = 0
        while q:
            cur = q.popleft() + q.pop()
            ans = max(ans, cur)
        return ans