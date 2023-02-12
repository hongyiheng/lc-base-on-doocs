# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        tmp = ans
        cur = 0
        while head:
            if head.val == 0 and cur:
                tmp.next = ListNode(cur)
                tmp = tmp.next
                cur = 0
            cur += head.val
            head = head.next
        return ans.next