package Shoppingcart;
public enum RankPromotion {
    NONE(0, 0),
    SILVER(0, 50),
    GOLD(2, 0),
    DIAMOND(3, 0);

    public final double productDiscountPercent;
    public final double shippingDiscountPercent;

    RankPromotion(double productDiscount, double shippingDiscount) {
        this.productDiscountPercent = productDiscount;
        this.shippingDiscountPercent = shippingDiscount;
    }
}

