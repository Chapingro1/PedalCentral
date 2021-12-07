package core.domain

import kotlin.jvm.JvmInline

@JvmInline
value class Preset(private val outputMap : Map<Int, Double>){
    init{
        for (key in outputMap.keys){
            if (key < 0){
                throw(IllegalArgumentException("Keys for outputMap must be Positive Integers"))
            } else continue
        }
        for (value in outputMap.values){
            if (value !in 0.0..1.0){
                throw (IllegalArgumentException("Values for outputMap must be in the range [0.0, 1.0]"))
            }
        }
    }

    fun getOutputs(): Map<Int,Double> = outputMap

}

