package platform.data.data

import platform.data.PlatformGPIOPins.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.*

internal class PlatformGPIOPinsTest{

    @Test
    @DisplayName("this mock represents pins corresponding to ordinals [1, 3] and [8, 10].")
    fun `this mock represents pins corresponding to ordinals 1 to 3 and 8 to 10`(){
        println(PIN1.ordinal)
        for (i in 0..4){
            assertEquals(PlatformGPIOPins.values()[i].pinNumber, PlatformGPIOPins.values()[i].ordinal)
        }
    }
}