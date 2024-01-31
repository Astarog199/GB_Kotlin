package main.kotlin.СontactBook

class ContactsBook(){

    private var users = ArrayList<Person>()
    private var comList = ArrayList<String?>()

       fun getUsers(): ArrayList<Person> {
           return users
       }

    fun addUser(person: Person){
        users.add(person)
    }


    //— Напишите функцию readCommand(): Command, которая читает команду из текстового ввода,
    // распознаёт её и возвращает один из классов-наследников Command, соответствующий введённой команде.
    fun readCommand(): Command {
        println("Введите команду:")
        val input = readlnOrNull()?.lowercase()
        comList.add(input)
        when(input) {
            "exit" -> println("Конец программы")
            "help" -> return Help()
            "add" -> return Add()
            "get" -> return GetContactsBook(input)
            "show" -> return Show(comList)
            else -> {
                println("Некорректный ввод")
            }
        }
        return Help()
    }

}