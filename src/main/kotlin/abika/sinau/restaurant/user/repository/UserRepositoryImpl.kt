package abika.sinau.restaurant.user.repository

import abika.sinau.restaurant.database.DatabaseComponent
import abika.sinau.restaurant.user.entity.User
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> = databaseComponent.database.getDatabase("user").getCollection()

    override fun getUsers(): List<User> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String, address: String, city: String, province: String, nation: String, religion: String, gender: String, age: Int): List<User> {
        val newUser = User(name = name, address = address, city = city, province = province, nation = nation, religion = religion, gender = gender, age = age)
        val insertUser = userCollection().insertOne(newUser)

        return if (insertUser.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("Insert User Role Gagal ")
        }
    }

    override fun getUserByName(name: String): User? {
        return userCollection().findOne(User::name eq name)
    }

    override fun getUserByReligion(religion: String): User? {
        return userCollection().findOne(User::religion eq religion)
    }

    override fun getUserByAge(age: Int): User? {
        return userCollection().findOne(User::age eq age)
    }

    override fun getUserByCity(city: String): User? {
        return userCollection().findOne(User::city eq city)
    }
}