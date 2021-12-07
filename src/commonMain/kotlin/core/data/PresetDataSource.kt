package core.data

import core.domain.Preset

interface PresetDataSource {

    fun getPreset(index : Int) : Preset

    fun getPresets() : Map<Int, Preset>

    fun addPreset(index : Int, preset : Preset) : PresetDataSource

    fun addPresets(newPresetMap : Map<Int, Preset>) : PresetDataSource

    fun removePreset(index : Int) : PresetDataSource
}