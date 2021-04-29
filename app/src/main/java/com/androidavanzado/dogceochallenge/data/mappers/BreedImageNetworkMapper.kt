package com.androidavanzado.dogceochallenge.data.mappers

import com.androidavanzado.dogceochallenge.data.model.BreedImageNetworkEntity
import com.androidavanzado.dogceochallenge.domain.model.BreedImageData
import com.androidavanzado.dogceochallenge.domain.util.EntityMapper
import javax.inject.Inject

class BreedImageNetworkMapper
@Inject
constructor() : EntityMapper<BreedImageNetworkEntity, BreedImageData> {

    override fun mapFromEntity(entity: BreedImageNetworkEntity): BreedImageData {
        return BreedImageData(
            message = entity.message,
            status = entity.status
        )
    }

    override fun mapToEntity(domainModel: BreedImageData): BreedImageNetworkEntity {
        return BreedImageNetworkEntity(
            message = domainModel.message,
            status = domainModel.status
        )
    }

    fun mapFromEntityList(entities: List<BreedImageNetworkEntity>) : List<BreedImageData> {
        return entities.map { mapFromEntity(it) }
    }

}