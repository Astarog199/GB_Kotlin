package main.kotlin.СontactBook

//— В каждом классе иерархии должна быть функция isValid(): Boolean, которая возвращает true, если команда введена
//с корректными аргументами. Проверку телефона и email нужно перенести в эту функцию.
//— Напишите функцию readCommand(): Command, которая читает команду из текстового ввода, распознаёт её и возвращает
//один из классов-наследников Command, соответствующий введённой команде.

interface Command {
    fun isValid(type: String, str:String): Boolean
    fun readCommand()
}

//val readCommand = object : Command{
//    override fun isValid(str: String): Boolean {
//
//        return true
//    }
//}