package core.domain

import kotlin.test.*
import kotlin.test.Test
import kotlin.test.assertIs

internal class PresetTest{

    @Test
    fun `The Preset constructor requires a presetMap`(){
        assertIs<Preset>(Preset(outputMap0))
    }

    @Test
    fun `getOutputs returns a Map of Int to Double`(){
        assertIs<Map<Int, Double>>(preset0.getOutputs())
    }

    companion object{
        
        val outputMap0 = mapOf(
            0 to 0.0)
        
        val preset0 = Preset(outputMap0)

        
        val outputMap1 = mapOf(
            0 to 0.0,
            2 to 1.0
        )
        
        val preset1 = Preset(outputMap1)


        val outputMap2 = mapOf(
            0 to 0.0,
            1 to 0.1,
            2 to 0.2,
            3 to 0.3
        )
        
        val preset2 = Preset(outputMap2)
        
        
        val ouputMap3 = mapOf(
            28 to 0.28,
            13 to 0.69,
            18 to 0.0231,
            2 to 1.0
        )
        
        val preset3 = Preset(ouputMap3)
        
        
        val outputMap4 = mapOf(
            0 to 0.001,
            1 to 0.002,
            3 to 0.004,
            29 to 0.030,
            23 to 0.999999999999999999999999999999999999999999999999
        )
        
        val preset4 = Preset(outputMap4)
        
        
        val outputMap5 = mapOf(
            5 to 0.50)
        
        val preset5 = Preset(outputMap5)
        
    }
}

