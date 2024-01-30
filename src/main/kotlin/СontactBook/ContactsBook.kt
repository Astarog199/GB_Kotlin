package main.kotlin.СontactBook

class ContactsBook() : Command {

    private var users = ArrayList<Person>()


    /*
    — Добавьте новую команду show, которая выводит последнее значение, введённой с помощью команды add.
    Для этого значение должно быть сохранено в переменную типа Person.
    Если на момент выполнения команды show не было ничего введено, нужно вывести на экран сообщение “Not initialized”.
     */

    private fun add() {
        val name = addName()
        var phone = ""
        var email = ""
        println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
        val input = readlnOrNull()?.lowercase() //чтение из консоли
        when {
            input == "exit" -> println("Выход")
            input == "phone" -> phone = addPhone()
            input == "email" -> email = addEmail()
            else -> {
                println("Ошибка ввода. попробуйте еще раз или введите exit для выхода")
                add()
            }
        }
        users.add(Person(name, phone, email))
        readCommand()
    }

    private fun show(): Person? {
        val index: Int = users.size - 1
        if (index>=0) return users.get(index)
        println("Not initialized.")
        return null
    }

    /**
     * Метод проверяет введённое значение пользователем
     * добавляет полученное значение в переменную phone
     */
    private fun addPhone(): String {
        println("Введите номер телефона")
        var phone = readln()
        while (!isValid("phone", phone)) {
            println("Некорректный ввод номера телефона")
            phone = readln()
        }
        return phone
    }

    // #region: проверка, рефакторинг и добавление имени
    private fun addName(): String {
        println("Введите имя контакта")
        var name = readLine()

        while (!isValid("name", name!!)) {
            println("Некорректный ввод имени")
            name = readLine()
        }
        val refactorName = funRefactorName(name)
        return refactorName
    }

    private fun funRefactorName(name: String?): String {
        val refactorName = name?.lowercase()?.trim()
        return buildString {
            append(refactorName?.substring(0, 1)?.toUpperCase())
            append(refactorName?.substring(1, refactorName.length))
        }
    }
// #endregion

    /**
     * Метод проверяет введённое значение пользователем
     * добавляет полученное значение в переменную email
     */

    private fun addEmail(): String {
        println("Введите почту")
        var email = readln()
        while (!isValid("email", email)) {
            println("Некорректный ввод")
            email = readln()
        }
        return email
    }

    private fun printPhoneBook() {
        for (user in users) {
            println(user)
        }
    }

    private fun help() {
        println("exit для выхода")
        println("add для добавления контакта")
        println("get для получения контактов")
        println("show для получения последнего контакта")
    }

    override fun isValid(type: String, str: String): Boolean {
        if (type == "name")  return str.matches(Regex("""[A-Za-z а-яёА-ЯЁ]+"""))
        if (type == "phone") return str.matches(Regex("""[0-9+]+"""))
        if (type == "email") return str.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+"""))
        return false
    }

    override fun readCommand() {
        help()
        val input = readlnOrNull()?.lowercase()
        when {
            input == "exit" -> println("Конец программы")
            input == "help" -> help()
            input == "add" -> add()
            input == "get" -> printPhoneBook()
            input == "show" -> println(show())
            else -> {
                println("Некорректный ввод")
                help()
            }
        }

    }

}