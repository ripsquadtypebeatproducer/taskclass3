
@file:Suppress("UNREACHABLE_CODE")

import kotlin.math.abs


class Point(val x: Double, val y: Double)

class Triangle(private val a: Point, private val b: Point, private val c: Point) {

    fun isPointInside(point: Point): Boolean {

        val areaABC = 0.5 * abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
        val areaPBC = 0.5 * abs(point.x * (b.y - c.y) + b.x * (c.y - point.y) + c.x * (point.y - b.y))
        val areaPCA = 0.5 * abs(point.x * (c.y - a.y) + c.x * (a.y - point.y) + a.x * (point.y - c.y))
        val areaPAB = 0.5 * abs(point.x * (a.y - b.y) + a.x * (b.y - point.y) + b.x * (point.y - a.y))

        return areaPBC + areaPCA + areaPAB == areaABC
    }
}
fun main() {
    println("Задача 3: Выбор наибольшего и наименьшего расстояний")
    print("Введите количество точек: ")
    val numPoints = readlnOrNull()?.toIntOrNull() ?: 0

    if (numPoints < 3) {
        println("Количество точек должно быть больше двух.")
        return
    }

    val points = mutableListOf<Point>()
    println("Введите координаты точек (x, y):")
    for (i in 1..numPoints) {
        print("Точка $i: ")
        val x = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        val y = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        points.add(Point(x, y))
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in 0..<points.size) {
        for (j in i + 1..<points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) {
                minDistance = distance
            }
            if (distance > maxDistance) {
                maxDistance = distance
            }
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
    println()
}

private fun Point.distanceTo(point: Point): Double {

    return TODO("Provide the return value")
}
