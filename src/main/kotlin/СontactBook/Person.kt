package main.kotlin.СontactBook

/**
 * Класс Person представляет собой запись о человеке.
 * Этот класс содержит поля:
 *  name – имя человека
 *  phone – номер телефона
 *  email – адрес электронной почты
 */

data class Person (
    //ToDo: Измените класс Person так, чтобы он содержал список телефонов и список почтовых адресов, связанных с человеком.
    private val name: String = "",
    private val phone: MutableList <String> = mutableListOf(),
    private val email: MutableList <String> = mutableListOf()

    ) {


    fun getName(): String {
        return name
    }

    fun getPhone(): MutableList<String>{
        return phone
    }

    fun getMail(): MutableList<String>{
        return email
    }

    fun addPhone(arg: String){
        phone.add(arg)
    }

    fun printPhone(){
        var step = 1
        for (i in phone){
            println("$step.phone: $i")
        step++
        }
    }

    fun addEmail(arg: String) {
        email.add(arg)
    }

    override fun toString(): String {
        return " name:$name\n phone=${getPhone()}\n email=$email\n)"
    }
}