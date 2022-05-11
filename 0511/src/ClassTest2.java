class Account {
    String id;
    String name;
    int balance;

    String info() {
        return "°èÁÂ¹øÈ£: " + this.id + ", ÀÌ¸§: " + this.name + ", ÀÜ¾×: " + this.balance;
    }

    void deposit(int balance){
        this.balance += balance;
    }

    void withdraw(int balance){
        if(balance > this.balance) System.out.println("ÀÜ¾× ºÎÁ·!");
        else this.balance -= balance;
    }
}
public class ClassTest2 {

    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.id = "10001";
        acc1.name = "È«±æµ¿";
        acc1.balance = 100000;

        System.out.println(acc1.info());
        acc1.deposit(10000);
        System.out.println(acc1.info());
        acc1.withdraw(5000);
        System.out.println(acc1.info());
    }

}
