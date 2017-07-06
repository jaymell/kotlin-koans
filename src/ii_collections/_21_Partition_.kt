package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
    val (undelivereds, delivereds) = customers.partition(fun (it: Customer): Boolean {
        val (dCt, uCt) = it.orders.partition{ it.isDelivered }
        if ( uCt.size > dCt.size ) return true
        return false
    })
    return undelivereds.toSet()
}
