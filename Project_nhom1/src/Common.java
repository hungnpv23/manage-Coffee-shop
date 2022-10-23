import java.util.Scanner;

public class Common implements Action{
    private String name;
    Common(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("Tên: ");
        setName(input.nextLine());
    }
    public void output(){
        System.out.println("Tên: "+getName());
    }
}
