import mvc.*

fun displayForUser(bank: QuestionBank, index:Int){
    //now display the question for the user
    println(bank.listQuestion[index])
    println("---------------------------------------")
    println("---------------------------------------")
    bank.listQuestion[index].listOfReponse.forEach { q ->
        println(q)
    }
}

fun displayReply(person: User, score:Int) {

    println("You're Lose, $person!")
    println("do you want to reply ?\n \n  press y to yes and n to no")
    val reply = readLine()
    if(reply == "y"){
        main()
    }else return
}

fun displaygift(person: User, score: Int) {
    println("You're Win, $person!")

    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")

    // This prints an empty line.
    println("")

    println("Your $score is Great job, $person!")
}

fun main() {
    println("------ welcome to TopQuiz -------")
    println("now give your name !!")
    val name = readLine() ?: "Avatar"
    val person = User(name)
    println("------ now waiting us -------")
    val question1 = Question("Dans quel caciquat fut débarqué Christophe Colomb et quel en était le cacique?",
        listOf<String>("Le Marien","la Maguana","le Xaragua","le Higuey"), response = 0 )
    val question2 = Question("Comment s’appelait le fort construit par les Espagnols avec les débris de la Santa-Maria naufragé le 24 décembre 1492 dans la baie de Caracol?"
        ,listOf<String>("Fort de france","Fort liberte","Fort de la Nativité","Fort-national"), response = 2 )
    val question3 = Question("Combien de jours Christophe Colomb et son équipage a passé sur l’eau avant d’arriver en Amérique?",
        listOf<String>("50 jours","70 jours","100 jours","15 jours"), response = 1 )
    val question4 = Question("Comment s’appelait les premiers habitants de l’île d’Haïti ?"
        ,listOf<String>("nord","cap-haitien","port-au-prince","Arawaks"), response = 3 )
    val question5 = Question("Quelle ville a été construite par les Espagnols ?",
        listOf<String>("Marien","Higuey","Isabella","Xaragua"), response = 2 )

    val bank = QuestionBank(listOf(question1,question2,question3,question4,question5))

    //now display the question for the user
    fun controller(bank: QuestionBank,person: User){
        var index: Int = 0
        var score: Int = 0
        do {
            displayForUser(bank, index)
            var responseUser = readLine()?.toInt() ?: 0
            if(bank.listQuestion[index].response == responseUser){
                score++
            }else{
                println("bad answer !")
            }
            index++
        }while (index < 5)

        if(score > 3){
            displaygift(person,score)
        }else{
            displayReply(person, score)
        }
    }
    controller(bank, person)
}

