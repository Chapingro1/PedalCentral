import core.domain.Preset
import core.domain.Valve
import kotlinx.cinterop.*
import kotlin.math.roundToInt

fun updateCIntArray(cIntArray: CArrayPointer<IntVar>, size: Int){
    for (i in 0 until size){
        cIntArray[i] = i
    }
}

fun updateCDoubleArray(cDoubleArray: CArrayPointer<DoubleVar>, size: Int){
    for (i in 0 until size){
        cDoubleArray[i] = i * 0.01
    }
}


fun startupPreset(valveIDs: CArrayPointer<IntVar>, valveOutputs : CArrayPointer<IntVar>, size: CPointer<IntVar>){

    //Replace later with call to get startup Preset
    val currentPreset = Preset(mapOf(
        Valve(26) to 0.0,
        Valve(22) to 1.0,
        Valve(27) to 0.0
    ))

    //Pull out PresetMap to init c arrays
    val currentPresetMap = currentPreset.getOutputs()

    size.pointed.value = currentPresetMap.size
    var i = 0
    for (valve in currentPresetMap.iterator()){
        valveIDs[i] = valve.key.pin
        valveOutputs[i] = valve.value.toInt()
//        println(valveOutputs[i])
        i++
    }

}

var valve1 = Valve(1)


