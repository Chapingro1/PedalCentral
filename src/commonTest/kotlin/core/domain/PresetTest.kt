package core.domain

import kotlin.test.*
import kotlin.test.Test
import kotlin.test.assertIs

internal class PresetTest{

    @Test
    fun `The Preset constructor requires a presetMap`(){
        assertIs<Preset>(Preset(presetMap0))
    }

    @Test
    fun `getOutputs returns a Map of Int to Double`(){
        assertIs<Map<Int, Double>>(preset0.getOutputs())
    }

    companion object{
        
        val presetMap0 = mapOf(
            0 to 0.0)
        
        val preset0 = Preset(presetMap0)

        
        val presetMap1 = mapOf(
            0 to 0.0,
            2 to 1.0
        )
        
        val preset1 = Preset(presetMap1)


        val presetMap2 = mapOf(
            0 to 0.0,
            1 to 0.1,
            2 to 0.2,
            3 to 0.3
        )
        
        val preset2 = Preset(presetMap2)
        
        
        val presetMap3 = mapOf(
            28 to 0.28,
            13 to 0.69,
            18 to 0.0231,
            2 to 1.0
        )
        
        val preset3 = Preset(presetMap3)
        
        
        val presetMap4 = mapOf(
            0 to 0.001,
            1 to 0.002,
            3 to 0.004,
            29 to 0.030,
            23 to 0.999999999999999999999999999999999999999999999999
        )
        
        val preset4 = Preset(presetMap4)
        
        
        val presetMap5 = mapOf(
            5 to 0.50)
        
        val preset5 = Preset(presetMap5)
        
    }
}

