package core.interactors

import kotlin.test.Test
import kotlin.test.assertIs

internal class PresetInteractorTest {

    @Test
    fun `PresetInteractor object is instantiated`() {
        assertIs<PresetInteractor>(PresetInteractor)
    }

    // getPresetMapAt

    @Test
    fun `getPresetMapAt returns the preset map corresponding to the given PresetId and PresetRepository`() {

    }

}