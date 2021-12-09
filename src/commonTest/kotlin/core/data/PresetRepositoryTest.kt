package core.data

import core.domain.Preset
import core.domain.PresetTest
import platform.PresetDataSourceImplTest
import kotlin.test.*

internal class PresetRepositoryTest{


    //PresetRepository(presetMap : Map<Int, Preset>) : PresetRepository
    @Test
    fun `Create Instance of PresetRepository with presetMap`(){
        assertIs<PresetRepository>(PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl1))
    }


    //getPreset(index : Int) : Preset
    @Test
    fun `getPreset returns the Preset object located at index`(){
        assertEquals(PresetTest.preset4, presetRepository2.getPreset(4))
    }

    @Test
    fun `getPreset throws an IllegalArgumentException for indices not in presetMap`(){
        assertFailsWith<IllegalArgumentException> { presetRepository1.getPreset(-1) }
    }


    //getPresets() : Map<Int, Preset>
    @Test
    fun `getPresets returns a map which keys each Preset object by index`(){
        assertIs<Map<Int, Preset>>(presetRepository3.getPresets())
    }

    //Show acutal use!!


    //addPreset(index : Int, preset : Preset) : PresetRepository
    @Test
    fun `addPreset returns a new PresetRepository`(){
        assertIs<PresetRepository>(presetRepository4.addPreset(23, PresetTest.preset5))
    }

    @Test
    fun `addPreset updates the old presetMap with the provided index and preset`(){
        val newPresetRepository4 = presetRepository4.addPreset(23, PresetTest.preset5)
        assertEquals(PresetTest.preset5, newPresetRepository4.getPreset(23))
    }

    @Test
    fun `addPreset overwrites the old Preset object at the provided index`(){
        val newPresetRepository5 = presetRepository5.addPreset(5, PresetTest.preset0)
        assertNotEquals(PresetTest.preset5, newPresetRepository5.getPresets()[5])
    }

    @Test
    fun `addPreset does not remove old Presets unless they are overwritten at the provided index`(){
        val newPresetRepository5 = presetRepository5.addPreset(0, PresetTest.preset0)
        assertEquals(PresetTest.preset5, newPresetRepository5.getPresets()[5])
    }


    //addPresets(newPresetMap : Map<Int, Preset>) : PresetRepository
    @Test
    fun `addPresets returns a new PresetRepository`(){
        assertIs<PresetRepository>(presetRepository1.addPresets(PresetDataSourceImplTest.presetMap2))
    }

    @Test
    fun `addPresets updates the old presetMap with the newPresetMap`(){
        val newPresetRepository1 = presetRepository1.addPresets(PresetDataSourceImplTest.presetMap3)
        assertEquals(PresetDataSourceImplTest.presetMap1[0], newPresetRepository1.getPreset(0))
        assertEquals(PresetDataSourceImplTest.presetMap1[1], newPresetRepository1.getPreset(1))
        assertEquals(PresetDataSourceImplTest.presetMap1[2], newPresetRepository1.getPreset(2))
        assertEquals(PresetDataSourceImplTest.presetMap1[3], newPresetRepository1.getPreset(3))
        assertNotEquals(PresetDataSourceImplTest.presetMap1[4], newPresetRepository1.getPreset(4))
        assertNotEquals(PresetDataSourceImplTest.presetMap1[5], newPresetRepository1.getPreset(5))
    }

    @Test
    fun `addPresets overwrites the old presetMap at indices in the provided newPresetMap`(){
        val newPresetRepository1 = presetRepository1.addPresets(mapOf<Int, Preset>(0 to PresetTest.preset5))
        assertNotEquals(PresetDataSourceImplTest.presetMap1, newPresetRepository1.getPresets())
    }

    @Test
    fun `addPresets does Not remove old Presets unless they are overwritten at indices in the newPresetMap`(){
        val newPresetRepository1 = presetRepository1.addPresets(mapOf<Int, Preset>(0 to PresetTest.preset5))
        assertEquals(PresetDataSourceImplTest.presetMap1[1], newPresetRepository1.getPresets()[1])
    }


    //removePreset(index : Int) : PresetRepository
    @Test
    fun `removePreset returns a new PresetRepository`(){
        assertIs<PresetRepository>(presetRepository3.removePreset(0))
    }

    @Test
    fun `removePreset returns a new PresetRepository without the Preset object at index provided`(){
        val newPresetRepository2 = presetRepository2.removePreset(0)
        assertNotEquals(presetRepository2.getPreset(0), newPresetRepository2.getPresets()[0])
    }

    @Test
    fun `removePreset throws an IllegalArgumentException for indices not in presetMap`(){
        assertFailsWith<IllegalArgumentException> { presetRepository1.removePreset(99) }
    }


    companion object {

        val presetRepository1 = PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl1)

        val presetRepository2 = PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl2)

        val presetRepository3 = PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl3)

        val presetRepository4 = PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl4)

        val presetRepository5 = PresetRepository(PresetDataSourceImplTest.presetDataSourceImpl5)
    }
}