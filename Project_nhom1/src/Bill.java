import java.util.Objects;
import java.util.Scanner;

public class Bill extends Common implements Action {
    private String banso;
    private final drink[] list_drink;
    private int dem;
    private float tongcong;

    Bill(){
        banso = "0";
        list_drink = new drink[100];
        dem = 0;
    }

    public String getBanso() {
        return banso;
    }

    public void setBanso(String banso) {
        this.banso = banso;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public void setTongcong(float tongcong) {
        this.tongcong = tongcong;
    }

    public float getTongcong() {
        return tongcong;
    }

    public void input(){
        Scanner input = new Scanner(System.in);
        int i = 0;
        super.input();

        System.out.print("Số Bàn: ");
        setBanso(input.nextLine());
        list_drink[i] = new drink();
        list_drink[i].input();
        i++;
        char ans;
        int dem = 1;
        System.out.print("Order Thêm ? (Y/N): ");
        ans = input.next().charAt(0);
        while (ans == 'Y' || ans == 'y') {
            list_drink[i] = new drink();
            list_drink[i].input();
            i++;
            System.out.print("Order thêm ? (Y/N): ");
            ans = input.next().charAt(0);
            dem++;
        }
        setDem(dem);
    }
    public void output(){
        super.output();
        System.out.println("Số bàn: " +getBanso());
        for (int i = 0 ; i < getDem() ; i++){
            list_drink[i].output();
        }
    }

    public void output2(){
        float s = 0;
        float thanhtien = 0;
        super.output();
        System.out.println("Số bàn: " +getBanso());
        for (int i = 0 ; i < getDem() ; i++){
            list_drink[i].output1();
            if (Objects.equals(list_drink[i].getNameofdirnk(), "1")) {
                thanhtien = list_drink[i].getSoluong() * 10;
            }
            else if (Objects.equals(list_drink[i].getNameofdirnk(), "2")) {
                thanhtien = list_drink[i].getSoluong() * 30;
            }
            else if (Objects.equals(list_drink[i].getNameofdirnk(), "3")) {
                thanhtien = list_drink[i].getSoluong() * 20;
            }
            s += thanhtien;
            setTongcong(s);
        }
        System.out.printf("                                                  Tổng tiền:  %.3f đ\n", s);

    }
    public void thanhtoan(){
        Scanner input = new Scanner(System.in);
        float tienthanhtoan = 0;
        float tienthua = 0;
        do {
            System.out.print("Tiền thanh toán: ");
            tienthanhtoan = Float.parseFloat(input.nextLine());
            if (tienthanhtoan < getTongcong()) {
                System.out.println("Số tiền không hợp lệ, vui lòng thử lại!");
            }
            else {

                tienthua = tienthanhtoan - getTongcong();
                System.out.printf("Tiền thừa: %.3f đ\n", tienthua);
                System.out.println("Thanh toán thành công!");

            }
        }while (tienthanhtoan < getTongcong());
        System.out.println("-- -- -- -- -- -- -- -- --");
    }
}
