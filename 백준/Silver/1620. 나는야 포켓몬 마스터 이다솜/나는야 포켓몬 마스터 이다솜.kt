import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = br.readLine().split(' ').map { it.toInt() }
    val nList = hashMapOf<String, String>()
    val nStringName = mutableListOf<String>()
    for (i in 1..N) {
        val nName = br.readLine()
        nList[nName] = i.toString()
        nStringName.add(nName)
    }
    for (j in 1..M) {
        val input = br.readLine()
        if (input.substring(0, 1) >= "0" && input.substring(0, 1) <= "9") {
            bw.write("${nStringName[input.toInt() - 1]}\n")
        } else {
            bw.write("${nList[input]}\n")
        }
    }
    bw.flush()
    bw.close()
}