package platform.data.data

import core.domain.Valve
import core.domain.ValveTest
import org.junit.jupiter.api.DisplayName
import kotlin.test.*

internal class ValveDataSourceImplTest{

    @Test
    @DisplayName("Create Instance of ValveDataSourceImpl with valveMap.")
    fun `Create Instance of ValveDataSourceImpl with valveMap`(){
        assertIs<ValveDataSourceImpl>(valveDataSourceImpl1)
    }

    @Test
    @DisplayName("getValve returns Valve at index with getter.")
    fun `getValve returns Valve at index with getter`(){
        assertEquals(ValveTest.valve0, valveDataSourceImpl1.getValve(0))
        assertEquals(ValveTest.valve1, valveDataSourceImpl1.getValve(1))
        assertEquals(ValveTest.valve2, valveDataSourceImpl1.getValve(2))
        assertEquals(ValveTest.valve3, valveDataSourceImpl1.getValve(3))
    }

    @Test
    @DisplayName("getValve throws an IllegalArgumentException if the given index is not in the valveMap keys.")
    fun `getValve throws an IllegalArgumentException if the given index is not in the valveMap keys`(){
        assertFailsWith(IllegalArgumentException::class) { valveDataSourceImpl2.getValve(10)}
    }

    @Test
    @DisplayName("getValves returns a list of Valve? ordered by valveMap index.")
    fun `getValues returns a list of Maybe Valve ordered by valveMap index`(){
        assertIs<List<Valve?>>(valveDataSourceImpl4.getValves())
    }

    @Test
    @DisplayName("getValves returns a list with length one greater than the highest index in valveMap.")
    fun `getValves returns a list with length one greater than the highest index in valveMap`(){
        assertEquals(valveMap3.keys.maxOrNull()?.inc(), valveDataSourceImpl3.getValves().size)
    }

    @Test
    @DisplayName("getValves returns a list with nulls at indices not represented in valveMap.")
    fun `getValves returns a list with nulls at indices not represented in valveMap`(){
        assertEquals(null, valveDataSourceImpl2.getValves()[1])
    }

    @Test
    @DisplayName("addValve returns a new ValveDataSourceImpl.")
    fun `addValve returns a new ValveDataSourceImpl`(){
        val newValveDataSourceImpl2 = valveDataSourceImpl2.addValve(1, ValveTest.valve1)
        assertNotSame(valveDataSourceImpl2, newValveDataSourceImpl2)
    }

    @Test
    @DisplayName("addValve updates the valveMap with the provided Valve with key 'index'.")
    fun `addValve updates the valveMap with the provided Valve with key 'index'`(){
        assertEquals(
            ValveTest.valve0,
            valveDataSourceImpl1.addValve(7, ValveTest.valve0).getValve(7)
        )
    }

    @Test
    @DisplayName("addValve overwrites anything located at the provided index.")
    fun `addValve overwrites anything located at the provided index`(){
        assertNotEquals(
            valveDataSourceImpl1.getValve(1),
            valveDataSourceImpl1.addValve(1, ValveTest.valve4).getValve(1))
    }

    @Test
    @DisplayName("addValves returns a new ValveDataSourceImpl.")
    fun `addValves returns a new ValveDataSourceImpl`(){
        assertNotSame(
            valveDataSourceImpl4,
        valveDataSourceImpl4.addValves(
            listOf())
            )
    }

    @Test
    @DisplayName("addValves overwrites the original valveMap with Valve objects in the parameter list.")
    fun `addValves overwrites the original valveMap with Valve objects in the parameter list`(){
        assertNotEquals(
            valveDataSourceImpl1.getValve(0),
            valveDataSourceImpl1.addValves(listOf(ValveTest.valve5)).getValve(0)
        )
    }

    @Test
    @DisplayName("addValves ignores null values in the parameter list.")
    fun `addValves ignores null values in the parameter list`(){
        val newValveDataSourceImpl = valveDataSourceImpl2.addValves(listOf(null, ValveTest.valve5))
        assertEquals(ValveTest.valve0, newValveDataSourceImpl.getValve(0))
        assertNotEquals(null, newValveDataSourceImpl.getValve(0))
        println(newValveDataSourceImpl)
    }

    @Test
    @DisplayName("removeValve returns a new ValveDataSourceImpl.")
    fun `removeValve returns a new ValveDataSourceImpl`(){
        assertNotSame(
            valveDataSourceImpl3,
            valveDataSourceImpl3.removeValve(0)
        )
    }

    @Test
    @DisplayName("removeValve returns a ValveDataSourceImpl without the Valve object at the given index.")
    fun `removeValve returns a ValveDataSourceImpl without the Valve object at the given index`(){
        assertEquals(null, valveDataSourceImpl1.removeValve(0).getValves()[0])
    }

    @Test
    @DisplayName("removeValve throws an IllegalArgumentException if the given index is not in the valveMap keys.")
    fun `removeValve throws an IllegalArgumentException if the given index is not in the valveMap keys`(){
        assertFailsWith(IllegalArgumentException::class) { valveDataSourceImpl4.removeValve(-1) }
    }


    companion object {
        val valveMap1 = mapOf<Int, Valve?>(
            (0 to ValveTest.valve0),
            (1 to ValveTest.valve1),
            (2 to ValveTest.valve2),
            (3 to ValveTest.valve3)
        )

        val valveDataSourceImpl1 = ValveDataSourceImpl(valveMap1)

        val valveMap2 = mapOf<Int, Valve?>(
            (0 to ValveTest.valve0),
            (2 to ValveTest.valve2),
            (4 to ValveTest.valve4)
        )

        val valveDataSourceImpl2 = ValveDataSourceImpl(valveMap2)

        val valveMap3 = mapOf<Int, Valve?>(
            (0 to ValveTest.valve0),
            (1 to ValveTest.valve1),
            (4 to ValveTest.valve4),
            (5 to ValveTest.valve5)
        )

        val valveDataSourceImpl3 = ValveDataSourceImpl(valveMap3)

        val valveMap4 = mapOf<Int, Valve?>(
            (0 to ValveTest.valve0),
            (1 to ValveTest.valve1),
            (2 to ValveTest.valve2),
            (3 to ValveTest.valve3),
            (4 to ValveTest.valve4),
            (5 to ValveTest.valve5),
        )

        val valveDataSourceImpl4 = ValveDataSourceImpl(valveMap4)
    }
}