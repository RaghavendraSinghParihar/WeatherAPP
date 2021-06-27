package com.health.test.mvvm.koin.model.weather


import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
        @SerializedName("city")
        var city: City?,
        @SerializedName("cnt")
        var cnt: Int?, // 40
        @SerializedName("cod")
        var cod: String?, // 200
        @SerializedName("list")
        var list: List<WeatherAll>?,
        @SerializedName("message")
        var message: Int? // 0
) {
    data class City(
            @SerializedName("coord")
            var coord: Coord?,
            @SerializedName("country")
            var country: String?, // IN
            @SerializedName("id")
            var id: Int?, // 1258598
            @SerializedName("name")
            var name: String?, // Rāmpur
            @SerializedName("population")
            var population: Int?, // 26257
            @SerializedName("sunrise")
            var sunrise: Int?, // 1624665075
            @SerializedName("sunset")
            var sunset: Int?, // 1624715666
            @SerializedName("timezone")
            var timezone: Int? // 19800
    ) {
        data class Coord(
                @SerializedName("lat")
                var lat: Double?, // 29.7977
                @SerializedName("lon")
                var lon: Double? // 77.4714
        )
    }

    data class WeatherAll(
            @SerializedName("clouds")
            var clouds: Clouds?,
            @SerializedName("dt")
            var dt: Double?, // 1624687200
            @SerializedName("dt_txt")
            var dtTxt: String?, // 2021-06-26 06:00:00
            @SerializedName("main")
            var main: Main?,
            @SerializedName("pop")
            var pop: Double?, // 0
            @SerializedName("sys")
            var sys: Sys?,
            @SerializedName("visibility")
            var visibility: Double?, // 10000
            @SerializedName("weather")
            var weather: List<Weather?>?,
            @SerializedName("wind")
            var wind: Wind?
    ) {
        data class Clouds(
                @SerializedName("all")
                var all: Double? // 0
        )

        data class Main(
                @SerializedName("feels_like")
                var feelsLike: Double?, // 313.23
                @SerializedName("grnd_level")
                var grndLevel: Double?, // 973
                @SerializedName("humidity")
                var humidity: Double?, // 27
                @SerializedName("pressure")
                var pressure: Double?, // 1002
                @SerializedName("sea_level")
                var seaLevel: Double?, // 1002
                @SerializedName("temp")
                var temp: Double?, // 312.12
                @SerializedName("temp_kf")
                var tempKf: Double?, // 0
                @SerializedName("temp_max")
                var tempMax: Double?, // 312.12
                @SerializedName("temp_min")
                var tempMin: Double? // 312.12
        )

        data class Sys(
                @SerializedName("pod")
                var pod: String? // d
        )

        data class Weather(
                @SerializedName("description")
                var description: String?, // clear sky
                @SerializedName("icon")
                var icon: String?, // 01d
                @SerializedName("id")
                var id: Double?, // 800
                @SerializedName("main")
                var main: String? // Clear
        )

        data class Wind(
                @SerializedName("deg")
                var deg: Double?, // 223
                @SerializedName("gust")
                var gust: Double?, // 3.41
                @SerializedName("speed")
                var speed: Double? // 1.61
        )
    }
}