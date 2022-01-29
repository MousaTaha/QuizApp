package com.example.figmatest

object Constant {
    const val USER_NAME:String = "username"
    const val Total_Quistion:String = "total_quistion"
    const val CORRECT_ANSWERS:String = "correct_answer"
    fun getQuestion():ArrayList<Questions>{
        var qustionArray = ArrayList<Questions>()
        var qu1 = Questions(1,"What is this country: ",R.drawable.jordan,
            "German",
            "Canada",
            "Palestine",
            "Jordan",4)
        var qu2 = Questions(1,"What is this country: ",R.drawable.brazil,
            "French",
            "Barzil",
            "Palestine",
            "Jordan",2)
        var qu3 = Questions(1,"What is this country: ",R.drawable.kuwait,
            "india",
            "Kuwait",
            "Palestine",
            "Sudan",2)
        var qu4 = Questions(1,"What is this country: ",R.drawable.indonisia,
            "Indonisia",
            "Russia",
            "Namsa",
            "Jordan",1)
        var qu5 = Questions(1,"What is this country: ",R.drawable.oman,
            "Morocoo",
            "Canada",
            "Syria",
            "Omman",4)

        var qu6 = Questions(1,"What is this country: ",R.drawable.pakistan,
            "America",
            "Pakistan",
            "Kazakhistan",
            "turkmanstan",2)

        var qu7 = Questions(1,"What is this country: ",R.drawable.palestine,
            "Iraq",
            "Canada",
            "Palestine",
            "Jordan",3)

        var qu8 = Questions(1,"What is this country: ",R.drawable.syria,
            "German",
            "Syria",
            "Iraq",
            "Turkya",2)

        var qu9 = Questions(1,"What is this country: ",R.drawable.nigeria,
            "Indonisia",
            "nigeria",
            "Kwuit",
            "Jordan",2)

        qustionArray.add(qu1)
        qustionArray.add(qu2)
        qustionArray.add(qu3)
        qustionArray.add(qu4)
        qustionArray.add(qu5)
        qustionArray.add(qu6)
        qustionArray.add(qu7)
        qustionArray.add(qu8)
        qustionArray.add(qu9)

        return qustionArray
    }
}