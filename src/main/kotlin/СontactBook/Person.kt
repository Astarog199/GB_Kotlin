package main.kotlin.СontactBook

/*
— Создайте data класс Person, который представляет собой запись о человеке. Этот класс должен содержать поля:
name – имя человека
phone – номер телефона
email – адрес электронной почты
 */

data class Person (
    val name: String = "",
    val phone: String? = "",
    val email: String? = ""
    /*
    методы equals, hashCode, toString генерируются автоматически
     */
)