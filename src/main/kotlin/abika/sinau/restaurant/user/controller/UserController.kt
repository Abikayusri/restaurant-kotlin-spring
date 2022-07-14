package abika.sinau.restaurant.user.controller

import abika.sinau.restaurant.BaseResponse
import abika.sinau.restaurant.user.entity.User
import abika.sinau.restaurant.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/user")
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUsers(): BaseResponse<List<User>> {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUsers()
        )
    }

    @PostMapping
    fun addUser(@RequestBody user: User): BaseResponse<List<User>> {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.addUser(user)
        )
    }

    @GetMapping("/name/{name}")
    fun getUserByName(@PathVariable(value = "name") name: String): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUserByName(name)
        )
    }

    @GetMapping("/religion/{religion}")
    fun getUserByReligion(@PathVariable(value = "religion") religion: String): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUserByReligion(religion)
        )
    }

    @GetMapping("/age/{age}")
    fun getUserByAge(@PathVariable(value = "age") age: Int): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUserByAge(age)
        )
    }

    @GetMapping("/city/{city}")
    fun getUserByCity(@PathVariable(value = "city") city: String): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUserByCity(city)
        )
    }
}