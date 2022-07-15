package com.simpleps.app.quarkus_template

import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.simpleps.quarkus_template.SampleRepository
import com.simpleps.quarkus_template.Sample

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SampleResource(
    val sampleRepository: SampleRepository
) {
    @POST
    @Transactional
    fun postAccount(sample: Sample): Sample {
        return sampleRepository.createSample(sample)
    }
}