package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.*

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    // derp: should have used lazy() here -- would have been one line
    val lazyValue: Int by LazyDelegate(initializer)
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)

// this should not exist
class LazyDelegate(val initializer: () -> Int) {
    var initialized: Boolean = false
    var myVar: Int = 0

	operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
           if (initialized == false) {
              initialized = true
              myVar = initializer()
          }
          return myVar
	}

	operator fun setValue(thisRef: Any?,
		property: KProperty<*>, value: Int) {
		myVar = value
	}
}
