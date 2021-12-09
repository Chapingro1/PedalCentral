package platform.init

import core.data.PresetRepository
import core.domain.Preset
import platform.data.PresetDataSourceImpl

object PresetInit {

    operator fun invoke() : PresetRepository {

        return PresetRepository(
            PresetDataSourceImpl(
                mapOf(
                    0 to Preset(mapOf(22 to 0.0, 26 to 0.0, 27 to 0.0)),
                    1 to Preset(mapOf(22 to 0.0, 26 to 1.0, 27 to 0.0)),
                    11 to Preset(mapOf(22 to 1.0, 26 to 1.0, 27 to 0.0)),
                    2 to Preset(mapOf(22 to 0.0, 26 to 1.0, 27 to 1.0)),
                    10 to Preset(mapOf(22 to 1.0, 26 to 0.0, 27 to 0.0)),
                    12 to Preset(mapOf(22 to 1.0, 26 to 1.0, 27 to 1.0)),
                )
            )
        )
    }
}