package chapter1;

/**
 * ReceiptPrinter
 */
@FunctionalInterface
public interface ReceiptPrinter {
    void print(Receipt receipt);

    private double getDiscountedPrice(Receipt receipt) {
        return receipt.price - (receipt.price * receipt.discount);
    }

    default double computeTotal(Receipt receipt) {
        double discountedPrice = getDiscountedPrice(receipt);
        return discountedPrice + (discountedPrice * receipt.tax);
    }
}

class ReceiptPrinterTest {
    public static void main(String[] args) {
        ReceiptPrinter simpleReceiptPrinter = new ReceiptPrinter(){
            @Override
            public void print(Receipt receipt) {
                System.out.println("\nItem:\t" + receipt.item);
                System.out.println("Price:\t" + receipt.price);
                System.out.println("Disc:\t" + receipt.discount);
                System.out.println("Tax:\t" + receipt.tax);
                System.out.println("Total:\t" + computeTotal(receipt));
            }
        };

        ReceiptPrinter exemptReceiptPrinter = new ReceiptPrinter(){
            @Override
            public void print(Receipt receipt) {
                System.out.println("\nItem:\t" + receipt.item);
                System.out.println("Price:\t" + receipt.price);
                System.out.println("Disc:\t" + receipt.discount);
                System.out.println("Total:\t" + computeTotal(receipt));
            }

            @Override
            public double computeTotal(Receipt receipt) {
                return receipt.price - (receipt.price * receipt.discount);
            }
        };

        Receipt receipt = new Receipt("shirt", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        exemptReceiptPrinter.print(receipt);
    }
}
