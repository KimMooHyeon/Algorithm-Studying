import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(val start: Int, val end: Int, val distance: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
    var tPlus = 0
    val maxParent = IntArray(n + 1) { it }

    val connect = mutableListOf<Edge>()

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect.add(Edge(temp[0], temp[1], temp[2]))


    }

    var smallSol: Long = 0
    var edgeNum: Long = 0

    connect.sortWith(compareBy { it.distance })
    connect.forEach {
        if (findParent(maxParent, it.start) != findParent(maxParent, it.end)) {
            unionParent(maxParent, it.start, it.end)
            edgeNum += 1
            smallSol += it.distance +tPlus
            tPlus+=t
        }
    }

    if (edgeNum == (n - 1).toLong()) {
        println(smallSol)
    } else {
        println(-1)
    }
}

fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        parent[x] = findParent(parent, parent[x])
    }
    return parent[x]
}

fun unionParent(parent: IntArray, x: Int, y: Int) {

    val xParent = findParent(parent, x)
    val yParent = findParent(parent, y)

    if (xParent < yParent) {
        parent[yParent] = xParent
    } else {
        parent[xParent] = yParent
    }
}
