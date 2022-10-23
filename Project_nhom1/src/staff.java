import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class staff extends Common implements Action, Serializable {
    private String id;
    private String address;
    private int Status;
    static ArrayList<staff> list1 = new ArrayList<>();
    File filenhanvien = new File("nhanvien.txt");
    public staff(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }


    public void input(){
        Scanner input = new Scanner(System.in);
        super.input();
        System.out.print("Nhập ID: ");
        setId(input.nextLine());
        System.out.print("Nhập địa chỉ: ");
        setAddress(input.nextLine());
        do{
            System.out.print("Trạng Thái: (1 - Part time    2 - Full time): ");
            setStatus(Integer.parseInt(input.nextLine()));
            if (getStatus()<1||getStatus()>2) System.out.println("Chỉ 1 hoặc 2 !!!");
        }while (getStatus()<1||getStatus()>2);

    }
    public void output(){
        super.output();
        System.out.println("ID: "+getId());
        System.out.println("Dia chi: "+getAddress());
        if(getStatus()==1) System.out.println("Trạng Thái: Part time");
        else if(getStatus()==2) System.out.println("Trạng Thái: Full time");

    }
    public void luong(){

        if(getStatus()==1) {
            System.out.println("Lương: 2.000.000đ /tháng");
        }else if(getStatus()==2){
            System.out.println("Lương: 5.000.000đ /tháng");
        }
    }
    public void writeFile(File file)
            throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list1);
            System.out.println("SAVE 100%");
        } catch (IOException e) {
            System.err.println("Contact to Admin to support!!!!");
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile(File file)
            throws IOException, FileNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list1 = (ArrayList<staff>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        }
        catch (Exception e) {
            System.out.println("File is empty");
        } finally {
            try {
                if(ois != null && fis != null) {
                    ois.close();
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "staff{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", Status=" + Status +
                ", filenhanvien=" + filenhanvien +
                '}';
    }
}