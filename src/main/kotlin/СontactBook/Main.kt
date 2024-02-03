package main.kotlin.СontactBook

/*
— Создайте иерархию sealed классов, которые представляют собой команды. В корне иерархии интерфейс Command.

— Функция main должна выглядеть следующем образом. Для каждой команды от пользователя:
Читаем команду с помощью функции readCommand
Выводим на экран получившийся экземпляр Command
Если isValid для команды возвращает false, выводим help. Если true, обрабатываем команду внутри when.

 */

fun main() {
    var status = true
    var book = ContactsBook()
    while (status){
        val  reader = book.readCommand()
          when(reader){
              is Help ->{
                  reader.run()
              }
              is GetContactsBook ->{
                  reader.run(book.getUsers())
              }
              is Add ->{
                  reader.run(book)
              }
              is Show ->{
                  reader.run()
              }
              is Find ->{
                  reader.run(book.getUsers())
              }
              //ToDo:Добавьте команду find, которая принимает email или телефон и выводит список людей, для которых записано такое значение.
              else -> {
                  println("Ошибка ввода")
              }
          }

    }
}