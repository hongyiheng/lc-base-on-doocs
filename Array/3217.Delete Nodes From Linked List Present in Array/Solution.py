# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        s = set(nums)
        dummy = ListNode()
        dummy.next = head
        cur = dummy
        while cur:
            while cur.next and cur.next.val in s:
                cur.next = cur.next.next
            cur = cur.next
        return dummy.next