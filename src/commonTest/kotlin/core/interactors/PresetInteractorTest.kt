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
    fun `getPresetMapAt returns the preset map from the preset with the given PresetId from the given PresetRepository`() {

    }

    @Test
    fun `previousPresetId returns the biggest presetId smaller than the given presetId in the given PresetRepository`() {

    }

    @Test
    fun `previousPresetId wraps and returns the largest presetId if given the smallest presetId`() {

    }

    @Test
    fun `nextPresetId returns the smallest presetId bigger than the given presetId in the given PresetRepository`() {

    }

    @Test
    fun `nextPresetId wraps and returns the smallest presetId if given the largest presetId`() {

    }

}