package platform

import core.data.PresetRepository
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object RuntimeData {

    var presetID : Int = -1

    lateinit var presetRepository: PresetRepository

}