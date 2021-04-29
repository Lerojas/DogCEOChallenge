package com.androidavanzado.dogceochallenge.data.mappers

import com.androidavanzado.dogceochallenge.data.model.BreedNameNetworkEntity
import com.androidavanzado.dogceochallenge.domain.model.BreedNameData
import com.androidavanzado.dogceochallenge.domain.util.EntityMapper
import javax.inject.Inject

class BreedNameNetworkMapper
@Inject
constructor() : EntityMapper<BreedNameNetworkEntity, BreedNameData> {

    override fun mapFromEntity(entity: BreedNameNetworkEntity): BreedNameData {
        return BreedNameData(
            message = entity.message,
            status = entity.status
        )
    }

    override fun mapToEntity(domainModel: BreedNameData): BreedNameNetworkEntity {
        return BreedNameNetworkEntity(
            message = domainModel.message,
            status = domainModel.status
        )
    }

    fun mapFromEntityList(entities: List<BreedNameNetworkEntity>) : List<BreedNameData> {
        return entities.map { mapFromEntity(it) }
    }

}