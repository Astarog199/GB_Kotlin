package main.kotlin.СontactBook

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