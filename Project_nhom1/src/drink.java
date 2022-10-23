import java.util.Objects;
import java.util.Scanner;

public class drink implements Action {
    private String nameofdirnk;
    private int soluong;

    drink() {

    }

    public String getNameofdirnk() {
        return nameofdirnk;
    }

    public void setNameofdirnk(String nameofdirnk) {
        this.nameofdirnk = nameofdirnk;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }


    public void input() throws NumberFormatException {
        Scanner input = new Scanner(System.in);
        System.out.println(" ---- Code of Drinks: 1. Coca     2. Milk Tea     3. Coffe ---- ");
        System.out.print("Input Code: ");
        setNameofdirnk(input.nextLine());

        try {
            while (getSoluong() <= 0) {
                System.out.print("Input Số lượng: ");
                setSoluong(Integer.parseInt(input.nextLine()));
                if (getSoluong() <= 0) {
                    System.out.println("Vui lòng nhập số lượng hợp lệ!");
                } else System.out.println("Order Successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số !");
        } catch (Exception e) {
            System.out.println("Lỗi" + e);
        }


    }

    public void output() {
        if (Objects.equals(getNameofdirnk(), "1")) {
            System.out.println("    Tên thức uống: " + "Coca" + "(" + getNameofdirnk() + ")" + "        Số lượng: " + getSoluong());
        }
        if (Objects.equals(getNameofdirnk(), "2")) {
            System.out.println("    Tên thức uống: " + "Milk tea" + "(" + getNameofdirnk() + ")" + "    Số lượng: " + getSoluong());
        }
        if (Objects.equals(getNameofdirnk(), "3")) {
            System.out.println("    Tên thức uống: " + "Coffee" + "(" + getNameofdirnk() + ")" + "      Số lượng: " + getSoluong());
        }
    }

    public void output1() {

        if (Objects.equals(getNameofdirnk(), "1")) {
            System.out.print("    Tên thức uống: " + "Coca" + "(" + getNameofdirnk() + ")" + "        Số lượng: " + getSoluong());
        }
        if (Objects.equals(getNameofdirnk(), "2")) {
            System.out.print("    Tên thức uống: " + "Milk tea" + "(" + getNameofdirnk() + ")" + "    Số lượng: " + getSoluong());
        }
        if (Objects.equals(getNameofdirnk(), "3")) {
            System.out.print("    Tên thức uống: " + "Coffee" + "(" + getNameofdirnk() + ")" + "      Số lượng: " + getSoluong());
        }

        // tính tiền
        float thanhtien = 0;
        if (Objects.equals(getNameofdirnk(), "1")) {
            thanhtien = getSoluong() * 10;
        } else if (Objects.equals(getNameofdirnk(), "2")) {
            thanhtien = getSoluong() * 30;
        } else if (Objects.equals(getNameofdirnk(), "3")) {
            thanhtien = getSoluong() * 20;
        }

        System.out.printf("     Thành tiền: %.3f đ\n", thanhtien);

    }

}
