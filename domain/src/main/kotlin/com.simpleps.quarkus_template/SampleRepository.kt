package com.simpleps.quarkus_template

interface SampleRepository {
    fun createSample(sample: Sample): Sample
}
