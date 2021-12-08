package platform.adaptors

import core.interactors.PresetInteractor

object PresetAdaptor {

    fun getPresetMapAt(presetId: Int): Map<Int, Double> =
        PresetInteractor.getPresetMapAt(DataModel.presetRepository, presetId)

    fun previousPresetId(presetId: Int): Int =
        PresetInteractor.previousPresetId(DataModel.presetRepository, presetId)

    fun nextPresetId(presetId: Int): Int =
        PresetInteractor.nextPresetId(DataModel.presetRepository, presetId)

}