package abika.sinau.restaurant.user.service

import abika.sinau.restaurant.user.entity.User
import abika.sinau.restaurant.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getUsers(): List<User> {
        return userRepository.getUsers()
    }

    override fun addUser(user: User): List<User> {
        return userRepository.addUser(
                name = user.name,
                address = user.address,
                city = user.city,
                province = user.province,
                nation = user.nation,
                religion = user.religion,
                gender = user.gender,
                age = user.age
        )
    }

    override fun getUserByName(name: String): User? {
        return userRepository.getUserByName(name)
    }

    override fun getUserByReligion(religion: String): User? {
        return userRepository.getUserByReligion(religion)
    }

    override fun getUserByAge(age: Int): User? {
        return userRepository.getUserByAge(age)
    }

    override fun getUserByCity(city: String): User? {
        return userRepository.getUserByCity(city)
    }
}