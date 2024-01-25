# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q = []
        while head:
            q.append(head.val)
            head = head.next
        l, r = 0, len(q) - 1
        while l < r:
            if q[l] != q[r]:
                break
            l += 1
            r -= 1
        return l >= r