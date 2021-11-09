package core.domain

import kotlin.test.*

internal class PresetTest{

    @Test
    fun `The Preset constructor requires an outputMap`(){

        assertIs<Preset>(Preset(outputMap0))
    }

    @Test
    fun `getOutputs returns a Map of Valve to Double`(){
        assertIs<Map<Valve,Double>>(preset0.getOutputs())
    }

    companion object{
        val outputMap0 = mapOf(
            ValveTest.valve0 to 0.0)

        val preset0 = Preset(outputMap0)
    }
}

