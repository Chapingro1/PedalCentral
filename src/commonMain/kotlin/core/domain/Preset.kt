package core.domain

data class Preset(private val outputMap : Map<Valve, Double>){

    fun getOutputs(): Map<Valve,Double> = outputMap

}
