package platform.data.data

import core.data.ValveDataSource
import core.domain.Valve

data class ValveDataSourceImpl(private val valveMap: Map<Int, Valve?>) : ValveDataSource {


    override fun getValve(index: Int) : Valve? {
        require(index in valveMap.keys)
        return valveMap[index]
    }

    override fun getValves() : List<Valve?> = List((valveMap.keys.maxOrNull()?.inc()?: 0)) {valveMap[it]}

    override fun addValve(index: Int, valve: Valve) : ValveDataSourceImpl = ValveDataSourceImpl(
        valveMap.plus(Pair(index, valve))
        )

    override fun addValves(nullableValvesList: List<Valve?>) : ValveDataSourceImpl = ValveDataSourceImpl(
        valveMap.plus(nullableValvesList.run { associateBy { indexOf(it)}}.filterNot { null == it.value })
        )


    override fun removeValve(index: Int) : ValveDataSourceImpl {
        require(index in valveMap.keys)
        return ValveDataSourceImpl( valveMap.minus(index))
        }
}
