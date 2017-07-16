package iii_conventions

import util.TODO


class Invokable {
    var invocations: Int = 0
}
fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })
fun Invokable.getNumberOfInvocations(): Int = invocations
fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}



operator fun Invokable.invoke(): Invokable {
  invocations++
  return this
}