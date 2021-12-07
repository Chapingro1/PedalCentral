package platform.data

import core.domain.Preset
import core.domain.PresetTest
import org.junit.jupiter.api.*
import kotlin.test.assertIs

internal class PresetDataSourceImplTest {

    @Test
    @DisplayName("Create Instance of PresetDataSourceImpl with presetMap.")
    fun `Create Instance of PresetDataSourceImpl with presetMap`(){
        assertIs<PresetDataSourceImpl>(PresetDataSourceImplTest.presetDataSourceImpl1)
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
    }
}