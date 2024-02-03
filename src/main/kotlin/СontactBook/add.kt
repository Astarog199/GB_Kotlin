package main.kotlin.СontactBook

class Add : Command {

    override fun isValid(): Boolean {
        return true
    }

    fun run(book: ContactsBook) {
        var users = book.getUsers()

        val name = addName()

        if (users.size == 0) book.addUser(addNewPerson(name))

        for (user in users) {
            if (user.getName() == name) {
                updatePerson(user, book)
            } else {
                book.addUser(addNewPerson(name))
            }
        }
    }
}

private fun updatePerson(user: Person, book: ContactsBook) {
    println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
    val reader = book.readCommand()


    val email = mutableListOf<String>()

    when (reader) {
        is Exit -> {}
        is AddPhone -> {
            if (reader.isValid()) {
                reader.run(user)
            } else {
                println("Некорректный ввод: должны только числа")
            }
        }

        is AddEmail -> {
            if (reader.isValid()){
                reader.run(user)
            }else{
                println("Некорректный ввод: пример mail@mail.ru")
            }
        }

        else -> {
            println("Ошибка ввода. попробуйте еще раз или введите exit для выхода")
        }
    }
}

private fun addNewPerson(name: String): Person {
    return Person(name)
}

/**
 *Метод добавляет имя
 */

private fun addName(): String {
    println("Введите имя контакта")
    var name = readln()
    while (!name.matches(Regex("""[A-Za-z а-яёА-ЯЁ]+"""))) {
        println("Некорректный ввод имени")
        name = readln()
    }
    val refactorName = funRefactorName(name)
    return refactorName
}

private fun funRefactorName(name: String): String {
    val refactorName = name.lowercase().trim()
    return buildString {
        append(refactorName.substring(0, 1).toUpperCase())
        append(refactorName.substring(1, refactorName.length))
    }
}