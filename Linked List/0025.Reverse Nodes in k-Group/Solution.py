# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head
        tail, tmp = head, head
        vals = []
        cnt = 0
        while tail:
            vals.append(tail.val)
            cnt += 1
            if cnt == k:
                while vals:
                    tmp.val = vals.pop()
                    tmp = tmp.next
                cnt = 0
                tmp = tail.next
            tail = tail.next
        return head