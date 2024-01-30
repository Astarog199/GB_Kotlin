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
    while (status){
        val book = ContactsBook()
        val  reader = book.readCommand()
          when(reader){
              is Help ->{
                  reader.run()
              }
              is GetContactsBook ->{
                  reader.run(book.getUsers())
              }
              is Add ->{
                  //TODO: Объект Person в ContactsBook() не добавляется
                  book.addUser(reader.run())
              }
              is Show ->{
                  reader.run()
              }
          }

    }
}