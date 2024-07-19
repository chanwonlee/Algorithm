class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def mergeTwoLists(l1, l2):
    if l1 and l2:
        if l1.val > l2.val:
            l1, l2 = l2, l1
        l1.next = mergeTwoLists(l1.next, l2)

    return l1 or l2


def sortList(head):
    if not (head and head.next):
        return head

    half, slow, fast = None, head, head
    while fast and fast.next:
        half, slow, fast = slow, slow.next, fast.next.next
    half.next = None

    l1 = sortList(head)
    l2 = sortList(slow)

    return mergeTwoLists(l1, l2)
