public class BTTH {
    interface Payable {
        void pay(double amount);
    }

    public static abstract class PaymentMethod {
        protected String accountName;
        protected String paymentId;

        public PaymentMethod(String accountName, String paymentId) {
            this.accountName = accountName;
            this.paymentId = paymentId;
        }

        public abstract void validate();
    }
    public static class CreditCard extends PaymentMethod implements Payable {
        private String cardNumber;
        private String cvv;
        private double creditLimit;

        public CreditCard(String accountName, String paymentId, String cardNumber, String cvv, double creditLimit) {
            super(accountName, paymentId);
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.creditLimit = creditLimit;
        }

        @Override
        public void validate() {
            if (cardNumber.length() == 16) {
                System.out.println("Thẻ tín dụng hợp lệ.");
            } else {
                System.out.println("Thẻ tín dụng KHÔNG hợp lệ (Yêu cầu 16 chữ số).");
            }
        }

        @Override
        public void pay(double amount) {
            if (amount <= creditLimit) {
                creditLimit -= amount;
                System.out.println("Thanh toán " + amount + " bằng thẻ tín dụng thành công. Hạn mức còn lại: " + creditLimit);
            } else {
                System.out.println("Thanh toán thất bại: Vượt quá hạn mức tín dụng.");
            }
        }
    }

    public static class EWallet extends PaymentMethod implements Payable {
        private String phoneNumber;
        private double balance;

        public EWallet(String accountName, String paymentId, String phoneNumber, double balance) {
            super(accountName, paymentId);
            this.phoneNumber = phoneNumber;
            this.balance = balance;
        }

        @Override
        public void validate() {
            if (phoneNumber.startsWith("0")) {
                System.out.println("Ví điện tử hợp lệ.");
            } else {
                System.out.println("Ví điện tử KHÔNG hợp lệ.");
            }
        }

        @Override
        public void pay(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Thanh toán " + amount + " từ ví điện tử thành công. Số dư còn lại: " + balance);
            } else {
                System.out.println("Thanh toán thất bại: Số dư không đủ.");
            }
        }
    }

    public static void main(String[] args) {
        CreditCard visa = new CreditCard("Nguyen Van A", "CC01", "1234567890123456", "123", 5000.0);
        visa.validate();
        visa.pay(1500.0);

        EWallet momo = new EWallet("Tran Thi B", "EW01", "0987654321", 2000.0);
        momo.validate();
        momo.pay(2500.0);

        Payable rewardPoints = new Payable() {
            private double conversionRate = 10.0;

            @Override
            public void pay(double amount) {
                double pointsNeeded = amount * conversionRate;
                System.out.println("Thanh toán bằng Điểm thưởng: Đã đổi " + pointsNeeded + " điểm cho số tiền " + amount + " USD.");
            }
        };

        rewardPoints.pay(100.0);
    }
}