class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        return my_string.map{it.toLowerCase()}.sorted().joinToString("")
    }
}