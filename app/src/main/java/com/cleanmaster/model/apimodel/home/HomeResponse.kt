package com.cleanmaster.model.apimodel.home

data class HomeResponse(
    val serviceCode: String,
    val serviceName: String,
    val serviceDescription: String,
    val noEmpReq: Int
)