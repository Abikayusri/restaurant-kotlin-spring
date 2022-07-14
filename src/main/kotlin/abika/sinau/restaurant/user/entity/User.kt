package abika.sinau.restaurant.user.entity

import java.util.UUID

data class User(
        var id: String = UUID.randomUUID().toString(),
        var name: String,
        var address: String,
        var city: String,
        var province: String,
        var nation: String,
        var religion: String,
        var gender: String,
        var age: Int
)
