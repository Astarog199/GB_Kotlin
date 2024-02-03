package main.kotlin.СontactBook

/*
— Добавьте новую команду show, которая выводит последнее значение, введённой с помощью команды add.
Для этого значение должно быть сохранено в переменную типа Person.
Если на момент выполнения команды show не было ничего введено, нужно вывести на экран сообщение “Not initialized”.
 */
//ToDo: Команда show должна принимать в качестве аргумента имя человека и выводить связанные с ним телефоны и адреса электронной почты.
class Show(val users: MutableList<Person>): Command {
    fun  run(){
        println("Введите имя человека чтобы выводить связанные с ним телефоны и адреса:")
        val inputName = readlnOrNull()
        for (user in users){
            if (user.getName() == inputName){
                if (user.getPhone().size != 0 )println(user.getPhone())
                if (user.getMail().size != 0)println(user.getMail())
            }else{
                println("Поиск контакта по запросу: $inputName\nне дал результатов")
            }
        }
    }

    override fun isValid(): Boolean {
        return true
    }
}