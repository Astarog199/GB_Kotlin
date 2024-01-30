package main.kotlin.СontactBook

class Add: Command {

    override fun isValid(): Boolean {
    return true
    }

    fun run() : Person{
        val name = addName()
        var phone = ""
        var email = ""
        println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
        val input = readlnOrNull()?.lowercase() //чтение из консоли
        when {
            input == "exit" -> return Person(name)
            input == "phone" -> phone = addPhone()
            input == "email" -> email = addEmail()
            else -> {
                println("Ошибка ввода. попробуйте еще раз или введите exit для выхода")
                run()
            }
        }
//        contactsBook.addUser(Person(name, phone, email))
        return Person(name, phone, email)
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

    /**
     * Метод проверяет введённое значение пользователем
     * добавляет полученное значение в переменную phone
     */

    private fun addPhone(): String {
        println("Введите номер телефона")
        var phone = readln()
        while (!phone.matches(Regex("""[0-9+]+"""))) {
            println("Некорректный ввод номера телефона")
            phone = readln()
        }
        return phone
    }

    /**
     * Метод проверяет введённое значение пользователем
     * добавляет полученное значение в переменную email
     */

    private fun addEmail(): String {
        println("Введите почту")
        var email = readln()
        while (!email.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+"""))) {
            println("Некорректный ввод")
            email = readln()
        }
        return email
    }
}