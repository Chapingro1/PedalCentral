package core.data

import core.domain.Valve

interface ValveDataSource {

    fun getValve(index : Int) : Valve?

    fun getValves() : List<Valve?>

    fun addValve(index : Int, valve : Valve) : ValveDataSource

    fun addValves( nullableValvesList : List<Valve?>) : ValveDataSource

    @Throws(IllegalArgumentException::class)
    fun removeValve(index : Int) : ValveDataSource
}