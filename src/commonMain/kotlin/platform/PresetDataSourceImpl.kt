package platform.data

import core.data.PresetDataSource
import core.domain.Preset

data class PresetDataSourceImpl(private val presetMap : Map<Int, Preset>) : PresetDataSource {


    override fun getPreset(index : Int) : Preset = presetMap[index] ?:
        throw IllegalArgumentException("Index provided is Not in the current presetMap")

    override fun getPresets() : Map<Int, Preset> = presetMap

    override fun addPreset(index: Int, preset: Preset) : PresetDataSourceImpl =
        PresetDataSourceImpl(presetMap.plus(index to preset))

    override fun addPresets(newPresetMap: Map<Int, Preset>): PresetDataSourceImpl =
        PresetDataSourceImpl(presetMap.plus(newPresetMap))

    override fun removePreset(index : Int) : PresetDataSourceImpl {
        presetMap[index] ?: throw IllegalArgumentException("Cannot remove Preset. Index not in current presetMap.")
        return PresetDataSourceImpl(presetMap.minus(index))
    }


}
