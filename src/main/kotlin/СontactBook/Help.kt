package main.kotlin.СontactBook

class Help: Command {
    override fun isValid(): Boolean {
        return true
    }
    fun run() {
        println("exit для выхода")
        println("add для добавления контакта")
        println("get для получения контактов")
        println("show для получения последнего контакта")
    }
}