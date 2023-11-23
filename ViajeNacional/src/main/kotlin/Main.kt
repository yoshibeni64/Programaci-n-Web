import Clases.*
import java.security.interfaces.DSAPublicKey

fun getDiscount(price: Double, coupon: String, calculateDiscount: (Double, String) -> Double): Double {
    return calculateDiscount(price, coupon)
}

fun main() {
    val coupon = "PROMO2020"
    val precio = 100.0

    val discountCalculator: (Double, String) -> Double = { price, coupon ->
        when (coupon) {
            "NOIVA" -> price
            "HALFIVA" -> price + price * 0.16 / 2
            "MINUS100" -> price - 100
            "PROMO2020" -> when {
                price <= 1000 -> price - price * 0.12
                price <= 2000 -> price - price * 0.04
                price <= 4000 -> price * 0.16 / 2
                else -> price / 3
            }
            else -> price + price * 0.16
        }
    }

    val finalPrice = getDiscount(precio, coupon, discountCalculator)
    println("El precio final es: $finalPrice")

    val viajeMonterrey = National("Monterrey")
    viajeMonterrey.quotePrice(2)
    val viajeBajaMonterrey = NationalLowSeason("Monterrey")
}