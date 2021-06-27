package com.health.test.mvvm.koin.model


import com.google.gson.annotations.SerializedName

data class TestDataResponse(
        @SerializedName("data")
        var `data`: Data? = null,
        @SerializedName("support")
        var support: Support? = null
) {
    data class Data(
            @SerializedName("avatar")
            var avatar: String? = "", // https://reqres.in/img/faces/2-image.jpg
            @SerializedName("email")
            var email: String? = "", // janet.weaver@reqres.in
            @SerializedName("first_name")
            var firstName: String? = "", // Janet
            @SerializedName("id")
            var id: Int?, // 2
            @SerializedName("last_name")
            var lastName: String? = "" // Weaver
    )

    data class Support(
            @SerializedName("text")
            var text: String? = "", // To keep ReqRes free, contributions towards server costs are appreciated!
            @SerializedName("url")
            var url: String? = "" // https://reqres.in/#support-heading
    )
}