package chapter1;

/**
 * ReceiptPrinter2
 */
@FunctionalInterface
public interface ReceiptPrinter2<T extends Receipt> {
    void print(T receipt);

    private double getDiscountedPrice(T receipt) {
        return receipt.price - (receipt.price * receipt.discount);
    }

    default double computeTotal(T receipt) {
        double discountedPrice = getDiscountedPrice(receipt);
        return discountedPrice + (discountedPrice * receipt.tax);
    }
}

class ReceiptPrinter2Test {
    public static void main(String[] args) {
        ReceiptPrinter2<Receipt> simpleReceiptPrinter = new ReceiptPrinter2<Receipt>() {
            @Override
            public void print(Receipt receipt) {
                System.out.println("\nItem:\t" + receipt.item);
                System.out.println("Price:\t" + receipt.price);
                System.out.println("Disc:\t" + receipt.discount);
                System.out.println("Tax:\t" + receipt.tax);
                System.out.println("Total:\t" + computeTotal(receipt));
            }
        };

        ReceiptPrinter2<CountyReceipt> countyReceiptPrinter = new ReceiptPrinter2<CountyReceipt>() {
            @Override
            public void print(CountyReceipt receipt) {
                System.out.println("\nItem:\t" + receipt.item);
                System.out.println("Price:\t" + receipt.price);
                System.out.println("Disc:\t" + receipt.discount);
                System.out.println("Tax:\t" + receipt.tax);
                System.out.println("CnTax:\t" + receipt.countyTax);
                System.out.println("Total:\t" + computeTotal(receipt));
            }

            @Override
            public double computeTotal(CountyReceipt receipt) {
                double discountedPrice = receipt.price - (receipt.price * receipt.discount);
                return discountedPrice + (discountedPrice * receipt.tax) + (discountedPrice * receipt.countyTax);
            }
        };

        Receipt receipt = new Receipt("shirt", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);

        CountyReceipt countyReceipt = new CountyReceipt(receipt, 0.04);
        countyReceiptPrinter.print(countyReceipt);
    }
}
