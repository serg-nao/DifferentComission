package ru.netology

fun main() {
    val monthSum: UInt = 15_000_00U
    val transfer: UInt = 200_70U
    val cardType: String = "Maestro"

    makeTransfer(transfer, monthSum, cardType)
}

fun makeTransfer(transfer: UInt, monthSum: UInt, cardType: String) {
    if (checkLimit(transfer, monthSum, cardType)) {
        val taxAmount = when (cardType) {
            "Mastercard" -> calculatorMastercard(transfer, monthSum)
            "Maestro" -> calculatorMaestro(transfer, monthSum)
            "Visa" -> calculatorVisa(transfer)
            "Мир" -> calculatorMir(transfer)
            else -> 0U
        }
        println("Комиссия составила $taxAmount")
    }
}

fun calculatorMir(transfer: UInt): Any {
    val minComission = 35_00U
    return if ((transfer * 75U / 10000U).toUInt() >= minComission) ((transfer * 75U / 10000U).toUInt()) else minComission
}

fun calculatorVisa(transfer: UInt): UInt {
    val minComission = 35_00U
    return if ((transfer * 75U / 10000U).toUInt() >= minComission) ((transfer * 75U / 10000U).toUInt()) else minComission
}

fun calculatorMaestro(transfer: UInt, monthSum: UInt): UInt {
    val minTransfer = 300_00U
    val maxFreeMonthSum = 75_000_00U
    val comission: UInt = when {
        (transfer > minTransfer) && (transfer + monthSum < maxFreeMonthSum) -> 0U
        (transfer <= minTransfer) || (monthSum >= maxFreeMonthSum) -> (transfer * 6U / 1000U).toUInt() + 20_00U
        else -> ((transfer + monthSum - maxFreeMonthSum) * 6U / 1000U) + 2000U
    }
    return comission
}

fun calculatorMastercard(transfer: UInt, monthSum: UInt): UInt {
    val minTransfer = 300_00U
    val maxFreeMonthSum = 75_000_00U
    val comission: UInt = when {
        (transfer > minTransfer) && (transfer + monthSum < maxFreeMonthSum) -> 0U
        (transfer <= minTransfer) || (monthSum >= maxFreeMonthSum) -> (transfer * 6U / 1000U).toUInt() + 20_00U
        else -> ((transfer + monthSum - maxFreeMonthSum) * 6U / 1000U) + 2000U
    }
    return comission
}

fun checkLimit(transfer: UInt, monthSum: UInt, cardType: String): Boolean {
    val limit: UInt = if (cardType == "VK") 40_000_00U else 600_000_00U
    val checkResult: Boolean = when {
        (monthSum >= limit) -> {
            println("Лимит переводов на текущий месяц исчерпан.")
            false
        }
        (monthSum + transfer > limit) -> {
            println("Сумма перевода превышает лимит, попробуйте уменьшить сумму перевода.")
            false
        }
        else -> {
            print("Перевод проведен. ")
            true
        }
    }
    return checkResult
}
