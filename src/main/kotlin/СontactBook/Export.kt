package main.kotlin.СontactBook

import java.io.File


class Export: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run(users:  MutableList<Person>){
        var text ="[\n"

        for (i in users){
            val user = i.toString()
            if (users.indexOf(i) != users.size-1) {
                text = "$text$user,\n"
            }else{
                text = "$text$user\n]"
            }
        }
        File("src/main/kotlin/UserDB/", "usersDB.json").writeText("")
        File("src/main/kotlin/UserDB/", "usersDB.json").appendText(text)
    }

}