# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        mp = dict()
        cur = 0
        while p:
            cur += p.val
            mp[cur] = p
            p = p.next
        cur = 0
        p = dummy
        while p:
            cur += p.val
            p.next = mp.get(cur).next
            p = p.next
        return dummy.next