def swapPairs(head):
    if head and head.next:
        p = head.next

        head.next = swapPairs(p.next)
        p.next = head
        return p
    return head
