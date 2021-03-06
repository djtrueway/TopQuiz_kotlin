

data class Question(var question:String ,var listOfReponse: kotlin.collections.List<String>, var response: Int){

    override fun toString(): String {
        return question
    }


    private fun question(value: Any): Any {
        return value
    }

}



class QuestionBank(var listQuestion:kotlin.collections.List<Question>) {


}