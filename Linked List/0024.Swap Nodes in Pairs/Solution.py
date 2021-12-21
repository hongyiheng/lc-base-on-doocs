# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        stk = []
        temp, cur = ListNode(), head
        head = temp
        while cur and cur.next:
            stk.append(cur)
            stk.append(cur.next)
            cur = cur.next.next
            temp.next = stk.pop()
            temp = temp.next
            temp.next = stk.pop()
            temp = temp.next
        temp.next = cur
        return head.next