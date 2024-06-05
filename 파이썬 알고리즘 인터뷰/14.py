def mergeTwoLists(list1, list2):
    if (not list1) or (list2 and list1.val > list2.val):
        list1, list2 = list2, list1
    if list1:
        list1.next = mergeTwoLists(list1.next, list2)
    return list1
