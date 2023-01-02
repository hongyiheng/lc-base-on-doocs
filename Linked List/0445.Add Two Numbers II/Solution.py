# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        s1, s2 = list(), list()
        while l1:
            s1.append(l1.val)
            l1 = l1.next
        while l2:
            s2.append(l2.val)
            l2 = l2.next
        i, j, carry = len(s1) - 1, len(s2) - 1, 0
        head = None
        while i >= 0 or j >= 0 or carry:
            cur = carry
            if i >= 0:
                cur += s1[i]
            if j >= 0:
                cur += s2[j]
            carry = cur // 10
            tmp = ListNode(cur % 10)
            tmp.next = head
            head = tmp
            i -= 1
            j -= 1
        return head