class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        var node = ListNode(0)
        val result = node
        var sum = 0
        while (list1 != null || list2 != null || sum > 0) {
            if (list1 != null) {
                sum += list1.`val`
                list1 = list1.next
            }
            if (list2 != null) {
                sum += list2.`val`
                list2 = list2.next
            }
            node.next = ListNode(sum % 10)
            sum /= 10
            node = node.next!!
        }
        return result.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
