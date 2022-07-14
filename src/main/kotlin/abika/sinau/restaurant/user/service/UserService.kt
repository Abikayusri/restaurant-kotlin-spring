package abika.sinau.restaurant.user.service

import abika.sinau.restaurant.user.entity.User

interface UserService {
    fun getUsers(): List<User>
    fun addUser(user: User): List<User>
    fun getUserByName(name: String): User?
    fun getUserByReligion(religion: String): User?
    fun getUserByAge(age: Int): User?
    fun getUserByCity(city: String): User?
}