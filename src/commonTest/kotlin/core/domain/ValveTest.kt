package core.domain

import kotlin.test.Test
import kotlin.test.assertIs


internal class ValveTest {

    @Test
    fun `Valve constructor requires a GPIOPin`(){
        assertIs<Valve>(valve0)
    }

    companion object {
        val valve0 = Valve(0)
        val valve1 = Valve(1)
        val valve2 = Valve(2)
        val valve3 = Valve(3)
        val valve4 = Valve(4)
        val valve5 = Valve(5)
    }
}

