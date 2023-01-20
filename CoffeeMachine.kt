package machine

var money = 550
var water = 400
var milk = 540
var coffeeBeans = 120
var disposableCups = 9

fun printCoffeeMachineState() {
    println("""
            The coffee machine has:
            ${water} ml of water
            ${milk} ml of milk
            ${coffeeBeans} g of coffee beans
            ${disposableCups} disposable cups
            $${money} of money
            """.trimIndent())
}

fun refillMachine(){
    
    println("Write how many ml of water you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeBeans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    disposableCups += readln().toInt()
    
}

fun buyFromMachine() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val type = readln().toInt()
    when (type) {
        1 -> {
            while (water > 249 && coffeeBeans > 15) {
                water -= 250
                coffeeBeans -= 16
                disposableCups -= 1
                money += 4
                break
            }
        }
        2 -> {
            while (water > 349 && milk > 74 && coffeeBeans > 19 ) {
                water -= 350
                milk -= 75
                coffeeBeans -= 20
                disposableCups -= 1
                money += 7
                break
            }
        }
        3 -> {
            while (water > 199 && milk > 99 && coffeeBeans > 11) {
                water -= 200
                milk -= 100
                coffeeBeans -= 12
                disposableCups -= 1
                money += 6
                break
            }
        }
    }
}

fun takeMoneyFromMachine(){
     println("I gave you $money")
     money = 0
}

fun doUserAction() {
    val userAction = readln()
    println("Write action (buy, fill, take)")
    when (userAction) {
        "buy" -> buyFromMachine()
        "fill" -> refillMachine()
        "take" -> takeMoneyFromMachine()
    }
}

fun main() {
    printCoffeeMachineState()
    doUserAction()
    printCoffeeMachineState()
}
