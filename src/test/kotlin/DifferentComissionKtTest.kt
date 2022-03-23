import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.*

class DifferentComissionKtTest {

    @Test
    fun makeTransfer_MastercardSuccessful() {
        //arrange
        val testTransfer = 10_000_00U
        val testMonthSum = 50_000_00U
        val testCardType = "Mastercard"

        //act
        val text = makeTransfer(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals("Платеж проведен. Комиссия составила 0", text)
    }

    @Test
    fun makeTransfer_MirSuccessful() {
        //arrange
        val testTransfer = 100_00U
        val testMonthSum = 10_000_00U
        val testCardType = "Мир"

        //act
        val text = makeTransfer(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals("Платеж проведен. Комиссия составила 3500", text)
    }

    @Test
    fun calculatorMir_FirstCase() {
        //arrange
        val testTransfer = 10_000_00U

        //act
        val comission = calculatorMir(
            transfer = testTransfer
        )

        //assert
        assertEquals(75_00U, comission)
    }

    @Test
    fun calculatorMir_SecondCase() {
        //arrange
        val testTransfer = 20_00U

        //act
        val comission = calculatorMir(
            transfer = testTransfer
        )

        //assert
        assertEquals(35_00U, comission)
    }

    @Test
    fun calculatorVisa_FirstCase() {
        //arrange
        val testTransfer = 10_000_00U

        //act
        val comission = calculatorVisa(
            transfer = testTransfer
        )

        //assert
        assertEquals(75_00U, comission)
    }

    @Test
    fun calculatorVisa_SecondCase() {
        //arrange
        val testTransfer = 20_00U

        //act
        val comission = calculatorVisa(
            transfer = testTransfer
        )

        //assert
        assertEquals(35_00U, comission)
    }

    @Test
    fun calculatorMaestro_FirstCase() {
        //arrange
        val testTransfer = 15_000_00U
        val testMonthSum = 50_000_00U

        //act
        val comission = calculatorMaestro(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(0U, comission)
    }

    @Test
    fun calculatorMaestro_SecondCase_SubcaseA() {
        //arrange
        val testTransfer = 100_00U
        val testMonthSum = 50_000_00U

        //act
        val comission = calculatorMaestro(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(2060U, comission)
    }

    @Test
    fun calculatorMaestro_SecondCase_SubcaseB() {
        //arrange
        val testTransfer = 1_000_00U
        val testMonthSum = 80_000_00U

        //act
        val comission = calculatorMaestro(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(2600U, comission)
    }

    @Test
    fun calculatorMaestro_ElseCase() {
        //arrange
        val testTransfer = 10_000_00U
        val testMonthSum = 70_000_00U

        //act
        val comission = calculatorMaestro(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(5000U, comission)
    }

    @Test
    fun calculatorMastercard_FirstCase() {
        //arrange
        val testTransfer = 15_000_00U
        val testMonthSum = 50_000_00U

        //act
        val comission = calculatorMastercard(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(0U, comission)
    }

    @Test
    fun calculatorMastercard_SecondCase_SubcaseA() {
        //arrange
        val testTransfer = 100_00U
        val testMonthSum = 50_000_00U

        //act
        val comission = calculatorMastercard(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(2060U, comission)
    }

    @Test
    fun calculatorMastercard_SecondCase_SubcaseB() {
        //arrange
        val testTransfer = 1_000_00U
        val testMonthSum = 80_000_00U

        //act
        val comission = calculatorMastercard(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(2600U, comission)
    }

    @Test
    fun calculatorMastercard_ElseCase() {
        //arrange
        val testTransfer = 10_000_00U
        val testMonthSum = 70_000_00U

        //act
        val comission = calculatorMastercard(
            transfer = testTransfer,
            monthSum = testMonthSum
        )

        //assert
        assertEquals(5000U, comission)
    }

    @Test
    fun checkLimit_VK_FirstCase() {
        //arrange
        val testTransfer = 10_000_00U
        val testMonthSum = 45_000_00U
        val testCardType = "VK"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(false, checkResult)
    }

    @Test
    fun checkLimit_VK_SecondCase() {
        //arrange
        val testTransfer = 15_000_00U
        val testMonthSum = 30_000_00U
        val testCardType = "VK"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(false, checkResult)
    }

    @Test
    fun checkLimit_VK_ThirdCase() {
        //arrange
        val testTransfer = 15_000_00U
        val testMonthSum = 10_000_00U
        val testCardType = "VK"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(true, checkResult)
    }

    @Test
    fun checkLimit_OtherCards_FirstCase() {
        //arrange
        val testTransfer = 10_000_00U
        val testMonthSum = 650_000_00U
        val testCardType = "Visa"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(false, checkResult)
    }

    @Test
    fun checkLimit_OtherCards_SecondCase() {
        //arrange
        val testTransfer = 35_000_00U
        val testMonthSum = 580_000_00U
        val testCardType = "Visa"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(false, checkResult)
    }

    @Test
    fun checkLimit_OtherCards_ThirdCase() {
        //arrange
        val testTransfer = 15_000_00U
        val testMonthSum = 10_000_00U
        val testCardType = "Visa"

        //act
        val checkResult = checkLimit(
            transfer = testTransfer,
            monthSum = testMonthSum,
            cardType = testCardType
        )

        //assert
        assertEquals(true, checkResult)
    }
}