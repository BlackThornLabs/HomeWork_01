package homework_01

/*
Задание #2
Реализуйте экстеншен функцию на список типизированный Person,
которая сортирует список по возрасту в порядке убывания

Реализуйте экстеншен функцию на список типизированный Person,
которая сортирует список в алфавитном порядке по имени. Если имена одинаковые, то учитывается фамилия

Задание #3
Реализуйте функцию высшего порядка, которая вычисляет время выполнения функции-аргумента и возвращает результат результат в миллисекунд
* */

// функция, которая сортирует список по возрасту в порядке убывания, но не меняет существующий список
fun MutableList<Person>.sortByAge() : MutableList<Person>{
    this.sortByDescending { it.age }
    return this
}

// функция, которая сортирует список в алфавитном порядке по имени. Если имена одинаковые, то учитывается фамилия
fun MutableList<Person>.sortByName() : MutableList<Person> {
    this.sortWith(compareBy<Person>{it.name}.thenBy {it.surname})
    return this
}
//функция, которая вычисляет время выполнения функции-аргумента и возвращает результат результат в миллисекундах
fun measureTimeMillis(funAsArgument: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    funAsArgument()
    val endTime = System.currentTimeMillis()
    return endTime - startTime
}

fun main() {

    val guys = mutableListOf(
        Person("John", "Doe", 30),
        Person("Jane", "Doe", 25),
        Person("Bob", "Smith", 40)
    )
    val andys = mutableListOf(
        Person("Andy", "Zombero", 33),
        Person("Andy", "Ivanoff", 12),
        Person("Andy", "Jiorjio", 77)
    )
    val mastodon = mutableListOf(
        Person("Brann", "Dailor", 48),
        Person("Troy", "Sanders", 49),
        Person("Bill", "Kelliher", 52),
        Person("Brent", "Hinds", 49)
    )


    val executionTime = measureTimeMillis { mastodon.sortByName().sortByAge() }

//    println(guys.sortByAge())

    println(andys.sortByName())

//    println("Execution time is $executionTime")

}