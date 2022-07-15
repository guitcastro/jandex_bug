package com.simpleps.app.quarkus_template

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import javax.inject.Inject

import com.simpleps.quarkus_template.SampleRepository
import com.simpleps.quarkus_template.Sample


@QuarkusTest
class AccountResourceTest {
    @Inject
    lateinit var sampleResource: SampleResource

    @Inject
    lateinit var sampleRepository: SampleRepository    

    @Test
    fun shouldReturnAndPersistAccount() {
        val sample = Sample()
        val newSample = sampleResource.postAccount(sample)
        assertNotNull(newSample.id)
    }
}
