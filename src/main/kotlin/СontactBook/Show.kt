package main.kotlin.СontactBook

/*
— Добавьте новую команду show, которая выводит последнее значение, введённой с помощью команды add.
Для этого значение должно быть сохранено в переменную типа Person.
Если на момент выполнения команды show не было ничего введено, нужно вывести на экран сообщение “Not initialized”.
 */

class Show(val comList: ArrayList<String?>): Command {
    fun  run(){
        for (com in comList){
            println(com)
        }
    }

    override fun isValid(): Boolean {
        return true
    }
}