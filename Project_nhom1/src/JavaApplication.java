import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class JavaApplication {

    public static int getMenu(){
        System.out.println("-- -- -- FMI COFFEE SHOP -- -- --");
        System.out.print(   "1.Xem Menu.\n"+
                            "2.Order.\n"+
                            "3.Danh Sach order.\n"+
                            "4.Thanh toan\n-----\n"+
                            "5.Thêm nhân viên.\n"+
                            "6.Xem danh sách nhân viên.\n"+
                            "7.Tìm nhân viên\n"+
                            "8.Xóa nhân viên\n"+
                            "9.Quit\n"+
                            "Please select a function: ");
        Scanner input = new Scanner(System.in);

        try{
            return input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Lưu ý, chỉ nhập số !!!");
        }
        return 0;
    }

    public static void dsmenu(){
        System.out.println("-- -- -- FMI MENU -- -- --");
        System.out.println("Code:1     Coca         Giá: 10.000đ");
        System.out.println("Code:2     Milk Tea     Giá: 30.000đ");
        System.out.println("Code:3     Coffee       Giá: 20.000đ");
    }





    public static void main(String[] args) {
        int chon;
        List<Bill> list = new ArrayList<>();
        ArrayList<staff> list1 = new ArrayList<>();
        staff st = new staff();
        while (true){
            chon = getMenu();
            switch (chon){
                case 1:
                    dsmenu();
                    break;
                case 2:
                    System.out.println("------ORDER------");
                    Bill b = new Bill();

                    b.input();
                    list.add(b);

                    break;
                case 3:
                    System.out.println("-- -- --DANH SÁCH ORDER-- -- --");
                    for (Bill b1 : list){
                        b1.output();
                        System.out.print(" ----------------- \n");
                    }
                    break;
                case 4:
                    String find;
                    boolean banso = false;
                    Scanner input = new Scanner(System.in);
                    System.out.println("-- -- THANH TOÁN -- --");
                    System.out.print("Nhập bàn thanh toán: ");
                    find = input.nextLine();
                    try{
                        for (Bill b1 : list){
                            if(Objects.equals(b1.getBanso(), find)){
                                banso = true;
                                b1.output2();
                                b1.thanhtoan();
                                list.remove(b1);
                            }
                        }
                    }catch (Exception e){
                        System.out.print("");
                    }

                    if(!banso)  {
                        System.out.println("Bàn không tồn tại!");
                    }
                    break;

                case 5:
                    System.out.println("------Thêm nhân viên--------");

                    st.input();
                    list1.add(st);
                    try {
                        st.writeFile(st.filenhanvien);
                    } catch (IOException e) {
                        System.out.println("Error!");
                    }

                    //lưu nhân viên vào file
                    /*
                    try {
                        FileOutputStream fos = new FileOutputStream("nhanvien.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(list1);

                        oos.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                     */



                    System.out.println("Thêm thành công");
                    break;


                case 6:
                    System.out.println("-----Danh sách nhân viên-----");
                    /*
                    try {
                        //đọc danh sách từ file
                        FileInputStream fis = new FileInputStream("nhanvien.txt");
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        list1 = (ArrayList<staff>) ois.readObject();

                        ois.close();
                        fis.close();

                        for (staff s : list1){
                            s.output();
                            System.out.println("---------------------");
                        }
                    } catch (EOFException e){
                        System.out.println("Quán mới mở chưa có nhân viên!");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                     */
                    try {
                        st.readFile(st.filenhanvien);
                    } catch (IOException e) {
                        System.out.println("Error!");
                    }
                    break;


                case 7:
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("-----Tìm nhân viên----");
                    System.out.print("Nhập id nhân viên cần tìm: ");
                    String id = input1.nextLine();
                    for (staff s : list1){
                        if (Objects.equals(s.getId(), id)){
                            s.output();
                            s.luong();
                        }
                    }
                    System.out.println("------------------------");
                    break;


                case 8:
                    String find1;
                    boolean nv = false;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("-- -- Xóa nhân viên -- --");
                    System.out.print("Nhập ID nhân viên cần xóa: ");
                    find1 = sc.nextLine();
                    try{
                        for (staff b2 : list1){
                            if(Objects.equals(b2.getId(), find1)){
                                nv = true;
                                list1.remove(b2);
                                System.out.println("Đã xóa!!");
                                //cập nhật lại danh sách khi đã xóa
                                FileOutputStream fos = new FileOutputStream("nhanvien.txt");
                                ObjectOutputStream oos = new ObjectOutputStream(fos);

                                oos.writeObject(list1);

                                oos.close();
                                fos.close();
                            }
                        }
                    }catch (Exception e){
                        System.out.print("");
                    }
                    if(!nv)  {
                        System.out.println("Nhân viên không có trong danh sách!");
                    }
                    break;


                case 9:
                    System.out.println("THOÁT HỆ THỐNG!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui lòng chọn lại!");
            }
        }
    }
}
