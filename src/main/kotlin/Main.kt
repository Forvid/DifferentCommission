fun main() {
    val cardType = "Mastercard" // по умолчанию Мир
    val previousTransfers = 50000.0 // сумма предыдущих переводов в рублях
    val currentTransfer = 80000.0 // текущий перевод в рублях

    val result = calculateCommission(cardType, previousTransfers, currentTransfer)
    println(result)
}

fun calculateCommission(cardType: String = "Мир", previousTransfers: Double = 0.0, currentTransfer: Double): String {
    val dailyLimit = 150_000
    val monthlyLimit = 600_000

    if (currentTransfer > dailyLimit) return "Превышен дневной лимит перевода."
    if (previousTransfers + currentTransfer > monthlyLimit) return "Превышен месячный лимит перевода."

    val commission = when (cardType) {
        "Mastercard" -> if (previousTransfers + currentTransfer > 75_000) currentTransfer * 0.006 + 20 else 0.0
        "Visa" -> maxOf(currentTransfer * 0.0075, 35.0)
        "Мир" -> 0.0
        else -> 0.0
    }

    return "Комиссия составит: ${commission} руб."
}
