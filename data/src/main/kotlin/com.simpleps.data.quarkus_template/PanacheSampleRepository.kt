package com.simpleps.data.quarkus_template

import javax.enterprise.context.ApplicationScoped
import com.simpleps.quarkus_template.Sample
import com.simpleps.quarkus_template.SampleRepository

@ApplicationScoped
class PanacheSampleRepository: SampleRepository {
    override fun createSample(sample: Sample): Sample {
        val entity = SampleEntity()
        entity.persistAndFlush()
        return Sample(id = entity.id)
    }
}
