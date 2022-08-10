import java.util.Stack

class MyQueue() {

    private var inbox: Stack<Int> = Stack<Int>()
    private var outbox: Stack<Int> = Stack<Int>()

    fun push(x: Int) {
        inbox.push(x)
    }

    fun pop(): Int {
        if (outbox.isEmpty()){
            while (inbox.isNotEmpty()) {
                outbox.push(inbox.pop())
            }
        }
        return outbox.pop()
    }

    fun peek(): Int {
        if (outbox.isEmpty()){
            while (inbox.isNotEmpty()) {
                outbox.push(inbox.pop())
            }
        }
        return outbox.peek()
    }

    fun empty(): Boolean {
        return inbox.isEmpty() && outbox.isEmpty()
    }

}