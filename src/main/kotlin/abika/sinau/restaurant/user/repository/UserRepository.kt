package abika.sinau.restaurant.user.repository

import abika.sinau.restaurant.user.entity.User

interface UserRepository {
    fun getUsers(): List<User>
    fun addUser(name: String, address: String, city: String, province: String, nation: String, religion: String, gender: String, age: Int): List<User>
    fun getUserByName(name: String): User?
    fun getUserByReligion(religion: String): User?
    fun getUserByAge(age: Int): User?
    fun getUserByCity(city: String): User?
}