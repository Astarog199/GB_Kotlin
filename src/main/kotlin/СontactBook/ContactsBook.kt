package main.kotlin.СontactBook

class ContactsBook(){
//ToDO: Теперь в телефонной книге могут храниться записи о нескольких людях. Используйте для этого наиболее подходящую структуру данных.
    private var users = mutableListOf<Person>()

       fun getUsers(): MutableList<Person> {
           return users
       }

    fun addUser(person: Person){
        users.add(person)
    }

    private fun addPhone(): String {
        println("Введите номер телефона")
        val phone = readln()
//        while (!phone.matches(Regex("""[0-9+]+"""))) {
//            println("Некорректный ввод номера телефона")
//            phone = readln()
//        }
        return phone
    }

    private fun addEmail(): String {
        println("Введите почту")
        val email = readln()
//        while (!email.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+"""))) {
//            println("Некорректный ввод")
//            email = readln()
//        }
        return email
    }

    //— Напишите функцию readCommand(): Command, которая читает команду из текстового ввода,
    // распознаёт её и возвращает один из классов-наследников Command, соответствующий введённой команде.
    fun readCommand(): Command {
        println("Введите команду:")
        val input = readlnOrNull()?.lowercase()
        when(input) {
            "exit" -> println("Конец программы")
            "help" -> return Help()
            "add" -> return Add()
            "get" -> return GetContactsBook(input)
            "show" -> return Show(users)
            "find" -> return Find()
            "phone" -> return AddPhone(addPhone())
            "email" -> return AddEmail(addEmail())
            else -> {
                println("Некорректный ввод")
            }
        }
        return Help()
    }

}