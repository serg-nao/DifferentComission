package ru.netology

fun main() {
    val monthSum: UInt = 15_000_00U
    val transfer: UInt = 200_70U
    val cardType: String = "Maestro"

    makeTransfer(transfer, monthSum, cardType)
}

fun makeTransfer(transfer: UInt, monthSum: UInt, cardType: String): String {
    val textResult = if (checkLimit(transfer, monthSum, cardType)) {
        val taxAmount = when (cardType) {
            "Mastercard" -> calculatorMastercard(transfer, monthSum)
            "Maestro" -> calculatorMaestro(transfer, monthSum)
            "Visa" -> calculatorVisa(transfer)
            "Мир" -> calculatorMir(transfer)
            else -> 0U
        }
        "Платеж проведен. Комиссия составила $taxAmount"
    } else "Платеж не прошел."
    return textResult
}

fun calculatorMir(transfer: UInt): UInt {
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
        (transfer <= minTransfer) || (monthSum >= maxFreeMonthSum) -> (transfer * 6U / 1_000U).toUInt() + 20_00U
        else -> ((transfer + monthSum - maxFreeMonthSum) * 6U / 1_000U) + 20_00U
    }
    return comission
}

fun calculatorMastercard(transfer: UInt, monthSum: UInt): UInt {
    val minTransfer = 300_00U
    val maxFreeMonthSum = 75_000_00U
    val comission: UInt = when {
        (transfer > minTransfer) && (transfer + monthSum < maxFreeMonthSum) -> 0U
        (transfer <= minTransfer) || (monthSum >= maxFreeMonthSum) -> (transfer * 6U / 1_000U).toUInt() + 20_00U
        else -> ((transfer + monthSum - maxFreeMonthSum) * 6U / 1_000U) + 20_00U
    }
    return comission
}

fun checkLimit(transfer: UInt, monthSum: UInt, cardType: String): Boolean {
    val limitVK = 40_000_00U
    val limitCards = 600_000_00U
    val limit: UInt = if (cardType == "VK") limitVK else limitCards
    val checkResult: Boolean = when {
        (monthSum >= limit) -> {
            //println("Лимит переводов на текущий месяц исчерпан.")
            false
        }
        (monthSum + transfer > limit) -> {
            //println("Сумма перевода превышает лимит, попробуйте уменьшить сумму перевода.")
            false
        }
        else -> {
            //print("Перевод проведен. ")
            true
        }
    }
    return checkResult
}
