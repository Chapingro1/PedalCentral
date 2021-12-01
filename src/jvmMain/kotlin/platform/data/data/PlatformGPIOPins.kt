package platform.data.data

import core.data.GPIOPins

enum class PlatformGPIOPins(val pinNumber: Int?) : GPIOPins{
    PIN0(0),
    PIN1(1),
    PIN2(2),
    PIN3(3),
    PIN4(null),
    PIN5(null),
    PIN6(null),
    PIN7(null),
    PIN8(8),
    PIN9(9),
}