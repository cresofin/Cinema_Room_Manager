package cinema
var actualRows = 1
var repeatRows = 1
var list1 = mutableListOf(mutableListOf("Cinema: "))
var list2 = mutableListOf(" ")
var exit = 0
var currentIncom  = 0
var totalIncom = 0
var rowNumber = 0
var seatNumber = 0
var percentage :Double = 0.0
var percentagePurchasedTickets = "0.00"
var purchasedTickets  = 0
var eDo = 0
var totalSeats : Int = 0

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    totalSeats = rows * seats

    if (totalSeats <= 60) {
        totalIncom = totalSeats * 10
    } else {
        totalIncom = (((rows / 2) * seats) * 10)  + (((rows - (rows / 2)) * seats) * 8)
    }
    repeat(seats) {
        list2 += (" ${actualRows}")
        actualRows++
    }
    list1.add(list2)

    repeat(rows) {
        list2 = mutableListOf("")
        list2 += ("${repeatRows} ")
        repeat(seats) {
            list2 += ("S ")
        }
        list1.add(list2)
        repeatRows++
    }

    do {
        println("")
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        println("")
        var optionMenu = readln().toInt()
        println("")

        when (optionMenu) {
            1 -> {
                for (i in 0..rows + 1) {
                    println(list1[i].joinToString(""))
                }
                continue
            }
            2 -> {
                eDo = 0
                do {
                    println("\nEnter a row number:")
                    rowNumber = readln().toInt()
                    println("Enter a seat number in that row:")
                    seatNumber = readln().toInt()
                    if(rowNumber !in 1..rows || seatNumber !in 1..seats){
                        println("Wrong input!")
                        continue
                    }
                    if (list1[rowNumber + 1][seatNumber + 1] == "S ") {
                        list1[rowNumber + 1][seatNumber + 1] = "B "
                        eDo = 1
                    } else {
                        println("That ticket has already been purchased!")
                    }
                } while (eDo == 0)

                if (rows * seats <= 60) {
                    println("Ticket price: \$10")
                    currentIncom += 10
                } else {
                    if (rowNumber <= rows / 2) {
                        println("Ticket price: \$10")
                        currentIncom += 10
                    } else {
                        println("Ticket price: \$8")
                        currentIncom += 8
                    }
                }
                println("")
                purchasedTickets += 1
                percentage = (purchasedTickets.toDouble() / totalSeats) * 100
                percentagePurchasedTickets = "%.2f".format(percentage)
                continue
            }
            3 -> {
                println("Number of purchased tickets: ${purchasedTickets}")
                println("Percentage: ${percentagePurchasedTickets}%")
                println("Current income: \$${currentIncom}")
                println("Total income: \$${totalIncom}")
                continue
            }
            else -> break
        }
    } while (exit == 0)
}
