package core.data

import core.domain.Preset

data class PresetRepository(val presetDataSource: PresetDataSource) {

    fun getPreset(index : Int) : Preset = presetDataSource.getPreset(index)

    fun getPresets() : Map<Int, Preset> = presetDataSource.getPresets()

    fun addPreset(index : Int, preset : Preset) : PresetRepository =
        PresetRepository( presetDataSource.addPreset(index, preset))

    fun addPresets(newPresetMap : Map<Int, Preset>) : PresetRepository =
        PresetRepository(presetDataSource.addPresets(newPresetMap))

    fun removePreset(index : Int) : PresetRepository =
        PresetRepository(presetDataSource.removePreset(index))

}
