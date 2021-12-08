package core.interactors

import core.data.PresetRepository

object PresetInteractor {

    fun getPresetMapAt(presetRepo: PresetRepository, presetId: Int): Map<Int, Double> {
        return presetRepo.getPreset(presetId).getOutputs()
    }

    fun previousPresetId(presetRepo: PresetRepository, presetId: Int): Int {
        val keys = presetRepo.getPresets().keys.sorted()
        val currentIndex = keys.indexOf(presetId)
        require(currentIndex != -1) {" presetId not found in PresetRepository "}
        val newIndex = (currentIndex + keys.size - 1) % keys.size
        return keys[newIndex]
   }

    fun nextPresetId(presetRepo: PresetRepository, presetId: Int): Int {
        val keys = presetRepo.getPresets().keys.sorted()
        val currentIndex = keys.indexOf(presetId)
        require(currentIndex != -1) {" presetId not found in PresetRepository "}
        val newIndex = (currentIndex + 1) % keys.size
        return keys[newIndex]
    }

    // New Comment
}