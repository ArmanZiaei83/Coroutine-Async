class Cat constructor(name : String , age : Int , place : String): Animal {

    private val animName = name
    private val animAge = age
    private val animPlace = place

    override fun animalName() {
        println("Cat Name : $animName")
    }

    override fun animalAge() {
        println("Cat Age : $animAge")
    }

    override fun animalPlaceForLiving() {
        println("Animal Living Place : $animPlace")
    }

    override fun run() {
        animalName()
        animalAge()
        animalPlaceForLiving()
    }
}

class Tiger constructor(name : String , age : Int , place : String) : Animal{

    private val tigerName = name
    private val tigerAge = age
    private val tigerPlace  = place

    override fun animalName() {
        println("Tiger Name : $tigerName")
    }

    override fun animalAge() {
        println("Tiger Age : $tigerAge")
    }

    override fun animalPlaceForLiving() {
        println("Tiger Living Place : $tigerPlace")
    }

    override fun run() {
        animalName()
        animalAge()
        animalPlaceForLiving()
    }
}