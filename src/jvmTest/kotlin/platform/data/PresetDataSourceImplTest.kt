package platform.data

import core.domain.Preset
import core.domain.PresetTest
import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

internal class PresetDataSourceImplTest {

    //PresetDataSourceImpl(presetMap : Map<Int, Preset>) : PresetDataSourceImpl
    @Test
    @DisplayName("Create Instance of PresetDataSourceImpl with presetMap.")
    fun `Create Instance of PresetDataSourceImpl with presetMap`(){
        assertIs<PresetDataSourceImpl>(presetDataSourceImpl1)
    }


    //getPreset(index : Int) : Preset
    @Test
    @DisplayName("getPreset returns the Preset object located at index.")
    fun `getPreset returns the Preset object located at index`(){
        assertEquals(PresetTest.preset4, presetDataSourceImpl2.getPreset(4))
    }

    @Test
    @DisplayName("getPreset throws an IllegalArgumentException for indices not in presetMap.")
    fun `getPreset throws an IllegalArgumentException for indices not in presetMap`(){
        assertThrows<IllegalArgumentException> { presetDataSourceImpl1.getPreset(-1) }
    }


    //getPresets() : Map<Int, Preset>
    @Test
    @DisplayName("getPresets returns a map which keys each Preset object by index.")
    fun `getPresets returns a map which keys each Preset object by index`(){
        assertIs<Map<Int, Preset>>(presetDataSourceImpl3.getPresets())
    }

    //Show actual use!!


    //addPreset(index : Int, preset : Preset) : PresetDataSourceImpl
    @Test
    @DisplayName("addPreset returns a new PresetDataSourceImpl.")
    fun `addPreset returns a new PresetDataSourceImpl`(){
        assertIs<PresetDataSourceImpl>(presetDataSourceImpl4.addPreset(23, PresetTest.preset5))
    }

    @Test
    @DisplayName("addPreset updates the old presetMap with the provided index and preset.")
    fun `addPreset updates the old presetMap with the provided index and preset`(){
        val newPresetDataSourceImpl4 = presetDataSourceImpl4.addPreset(23, PresetTest.preset5)
        assertEquals(PresetTest.preset5, newPresetDataSourceImpl4.getPreset(23))
    }

    @Test
    @DisplayName("addPreset overwrites the old Preset object at the provided index.")
    fun `addPreset overwrites the old Preset object at the provided index`(){
        val newPresetDataSourceImpl5 = presetDataSourceImpl5.addPreset(5, PresetTest.preset0)
        assertNotEquals(PresetTest.preset5, newPresetDataSourceImpl5.getPresets()[5])
    }

    @Test
    @DisplayName("addPreset does not remove old Presets unless they are overwritten at the provided index")
    fun `addPreset does not remove old Presets unless they are overwritten at the provided index`(){
        val newPresetDataSourceImpl5 = presetDataSourceImpl5.addPreset(0, PresetTest.preset0)
        assertEquals(PresetTest.preset5, newPresetDataSourceImpl5.getPresets()[5])
        }


    //addPresets(newPresetMap : Map<Int, Preset>) : PresetDataSourceImpl
    @Test
    @DisplayName("addPresets returns a new PresetDataSourceImpl.")
    fun `addPresets returns a new PresetDataSourceImpl`(){
        assertIs<PresetDataSourceImpl>(presetDataSourceImpl1.addPresets(presetMap2))
    }

    @Test
    @DisplayName("addPresets updates the old presetMap with the newPresetMap.")
    fun `addPresets updates the old presetMap with the newPresetMap`(){
        val newPresetDataSourceImpl1 = presetDataSourceImpl1.addPresets(presetMap3)
        assertAll(
            {assertEquals(presetMap1[0], newPresetDataSourceImpl1.getPreset(0))},
            {assertEquals(presetMap1[1], newPresetDataSourceImpl1.getPreset(1))},
            {assertEquals(presetMap1[2], newPresetDataSourceImpl1.getPreset(2))},
            {assertEquals(presetMap1[3], newPresetDataSourceImpl1.getPreset(3))},
            {assertNotEquals(presetMap1[4], newPresetDataSourceImpl1.getPreset(4))},
            {assertNotEquals(presetMap1[5], newPresetDataSourceImpl1.getPreset(5))},
        )
    }

    @Test
    @DisplayName("addPresets overwrites the old presetMap at indices in the provided newPresetMap.")
    fun `addPresets overwrites the old presetMap at indices in the provided newPresetMap`(){
        val newPresetDataSourceImpl1 = presetDataSourceImpl1.addPresets(mapOf<Int, Preset>(0 to PresetTest.preset5))
        assertNotEquals(presetMap1, newPresetDataSourceImpl1.getPresets())
    }

    @Test
    @DisplayName("addPresets does Not remove old Presets unless they are overwritten at indices in the newPresetMap.")
    fun `addPresets does Not remove old Presets unless they are overwritten at indices in the newPresetMap`(){
        val newPresetDataSourceImpl1 = presetDataSourceImpl1.addPresets(mapOf<Int, Preset>(0 to PresetTest.preset5))
        assertEquals(presetMap1[1], newPresetDataSourceImpl1.getPresets()[1])
        }


    //removePreset(index : Int) : PresetDataSourceImpl
    @Test
    @DisplayName("removePreset returns a new PresetDataSourceImpl.")
    fun `removePreset returns a new PresetDataSourceImpl`(){
        assertIs<PresetDataSourceImpl>(presetDataSourceImpl3.removePreset(0))
    }

    @Test
    @DisplayName("removePreset returns a new PresetDataSourceImpl without the Preset object at index provided.")
    fun `removePreset returns a new PresetDataSourceImpl without the Preset object at index provided`(){
        val newPresetDataSourceImpl2 = presetDataSourceImpl2.removePreset(0)
        assertNotEquals(presetDataSourceImpl2.getPreset(0), newPresetDataSourceImpl2.getPresets()[0])
    }

    @Test
    @DisplayName("removePreset throws an IllegalArgumentException for indices not in presetMap.")
    fun `removePreset throws an IllegalArgumentException for indices not in presetMap`(){
        assertThrows<IllegalArgumentException> { presetDataSourceImpl1.removePreset(99) }
    }


    companion object {
        val presetMap1 = mapOf<Int, Preset>(
            (0 to PresetTest.preset0),
            (1 to PresetTest.preset1),
            (2 to PresetTest.preset2),
            (3 to PresetTest.preset3)
        )

        val presetDataSourceImpl1 = PresetDataSourceImpl(presetMap1)

        val presetMap2 = mapOf<Int, Preset>(
            (0 to PresetTest.preset0),
            (2 to PresetTest.preset2),
            (4 to PresetTest.preset4)
        )

        val presetDataSourceImpl2 = PresetDataSourceImpl(presetMap2)

        val presetMap3 = mapOf<Int, Preset>(
            (0 to PresetTest.preset0),
            (1 to PresetTest.preset1),
            (4 to PresetTest.preset4),
            (5 to PresetTest.preset5)
        )

        val presetDataSourceImpl3 = PresetDataSourceImpl(presetMap3)

        val presetMap4 = mapOf<Int, Preset>(
            (0 to PresetTest.preset0),
            (1 to PresetTest.preset1),
            (2 to PresetTest.preset2),
            (3 to PresetTest.preset3),
            (4 to PresetTest.preset4),
            (5 to PresetTest.preset5),
        )

        val presetDataSourceImpl4 = PresetDataSourceImpl(presetMap4)

        val presetMap5 = mapOf<Int, Preset>(5 to PresetTest.preset5)

        val presetDataSourceImpl5 = PresetDataSourceImpl(presetMap5)
    }
}