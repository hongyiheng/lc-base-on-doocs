# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        pre = list1
        for i in range(a - 1):
            pre = pre.next
        tail = list1
        for i in range(b + 1):
            tail = tail.next
        pre.next = list2
        while list2.next:
            list2 = list2.next
        list2.next = tail
        return list1