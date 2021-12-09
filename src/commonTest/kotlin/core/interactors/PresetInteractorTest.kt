package core.interactors

import core.data.PresetRepositoryTest
import core.domain.PresetTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

internal class PresetInteractorTest {

    @Test
    fun `PresetInteractor object is instantiated`() {
        assertIs<PresetInteractor>(PresetInteractor)
    }

    // getPresetMapAt

    @Test
    fun `getPresetMapAt returns the output map from the preset with the given PresetId from the given PresetRepository`() {
        val expected = PresetTest.outputMap2
        val actual = PresetInteractor.getPresetMapAt(presetRepository1, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun `previousPresetId returns the biggest presetId smaller than the given presetId in the given PresetRepository`() {
        val expected = 0
        val actual = PresetInteractor.previousPresetId(presetRepository2, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun `previousPresetId wraps and returns the largest presetId if given the smallest presetId`() {
        val expected = 4
        val actual = PresetInteractor.previousPresetId(presetRepository2, 0)
        assertEquals(expected, actual)
    }

    @Test
    fun `nextPresetId returns the smallest presetId bigger than the given presetId in the given PresetRepository`() {
        val expected = 4
        val actual = PresetInteractor.nextPresetId(presetRepository2, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun `nextPresetId wraps and returns the smallest presetId if given the largest presetId`() {
        val expected = 0
        val actual = PresetInteractor.nextPresetId(presetRepository2, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun `previousPresetId throws IllegalArgumentException if given a presetId not in the PresetRepository`() {
        assertFailsWith<IllegalArgumentException> { PresetInteractor.previousPresetId(presetRepository2, 1) }
    }

    @Test
    fun `nextPresetId throws IllegalArgumentException if given a presetId not in the PresetRepository`() {
        assertFailsWith<IllegalArgumentException> { PresetInteractor.nextPresetId(presetRepository2, 1) }
    }

    companion object {
        val presetRepository1 = PresetRepositoryTest.presetRepository1
        val presetRepository2 = PresetRepositoryTest.presetRepository2
    }

}
