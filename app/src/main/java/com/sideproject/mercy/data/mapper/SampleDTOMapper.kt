/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.sideproject.mercy.data.mapper

import com.sideproject.mercy.data.local.SampleEntity
import com.sideproject.mercy.data.remote.dto.SampleDTO
import com.sideproject.mercy.domain.entity.SampleData

fun SampleDTO.toSampleData(): SampleData {
    return SampleData(
        id = 1, title = status, imageUrl = message
    )
}
fun SampleEntity.toSampleData(): SampleData {
    return SampleData(
        id = 1, title = title, imageUrl = imageUrl
    )
}