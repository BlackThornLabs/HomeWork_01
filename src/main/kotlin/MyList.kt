package homework_01

/*
Задание #1
Создайте список и заполните его целыми числами 0-99
Напишите следующую цепочку операторов
Удаляет из цепочки все нечетные числа
Берет слайс с 10 по 20 элементы
Добавляет к каждому элементу 1
 */

// создаём изменяемый список
val listOfNumbers = (0..99).toMutableList()

// цепочка операторов:
fun MutableList<Int>.chopAndMash(): Int {

    // принимаем список как аргумент
        val list = this

    // удаляем из списка нечётные числа
    removeIf{ it %2 != 0 }

    // увеличиваем значение каждого элемента слайса с 10 по 20 на 1
    for (i in list.subList(9, 19).indices) {
        list.subList(9, 19)[i] = list.subList(9, 19)[i] + 1
    }

    // суммируем значения всех элементов слайса, возвращаем результат
    return list.subList(9, 19).sum()
}

fun main () {
    println(listOfNumbers.chopAndMash())
}