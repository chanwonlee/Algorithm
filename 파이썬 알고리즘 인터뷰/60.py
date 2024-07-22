class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def insertionSortList(head):
    cur = parent = ListNode(0)
    while head:
        while cur.next and cur.next.val < head.val:
            cur = cur.next

        cur.next, head.next, head = head, cur.next, head.next

        if head and cur.val > head.val:
            cur = parent

    return parent.next
