package abika.sinau.restaurant.user.repository

import abika.sinau.restaurant.user.entity.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    private val userList: MutableList<User> = mutableListOf()

    init {
        userList.addAll(listOf(
                User(name = "Purwo", address = "Jl. Keputihan", city = "Bekasi", province = "Jawa Barat", nation = "Indonesia", religion = "Islam", gender = "Pria", age = 23),
                User(name = "Mario", address = "Jl. Keputihan", city = "Bekasi", province = "Jawa Barat", nation = "Indonesia", religion = "Islam", gender = "Pria", age = 23),
                User(name = "Agnes", address = "Jl. Keputihan", city = "Bekasi", province = "Jawa Timur", nation = "Amerika", religion = "Kristen", gender = "Wanita", age = 30),
        ))
    }

    override fun getUsers(): List<User> {
        return userList
    }

    override fun getUserByName(name: String): User? {
        return userList.find { it.name == name }
    }

    override fun addUser(name: String, address: String, city: String, province: String, nation: String, religion: String, gender: String, age: Int): List<User> {
        userList.add(User(name = name, address = address, city = city, province = province, nation = nation, religion = religion, gender = gender, age = age))
        return userList
    }

    override fun getUserByReligion(religion: String): User? {
        return userList.find { it.religion == religion }
    }

    override fun getUserByAge(age: Int): User? {
        return userList.find { it.age == age }
    }

    override fun getUserByCity(city: String): User? {
        return userList.find { it.city == city }
    }
}