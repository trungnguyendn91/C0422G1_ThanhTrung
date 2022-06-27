package Case_study.framework.service.impl;

import Case_study.framework.Model.Motor;
import Case_study.framework.service.IServiceMoto;

import java.util.ArrayList;
import java.util.Scanner;

public class MotoService implements IServiceMoto {
Scanner scanner = new Scanner(System.in);
private static final ArrayList<Motor> motorBikeList = new ArrayList<Motor>();
static {
    motorBikeList.add(new Motor("43D1-56789","Đức",2018,"Air blade",150 ));
    motorBikeList.add(new Motor("43D1-44444","Nhân",2020,"Exciter",150 ));
    motorBikeList.add(new Motor("43C1-22222","Huy",2016,"Sirius",110 ));
    motorBikeList.add(new Motor("43E1-99999","Phú",2021,"SH",150 ));
    motorBikeList.add(new Motor("43D5-56789","Hiệu",2017,"Winner",150 ));
}
@Override
public void display() {
    for (Object s : motorBikeList){
        System.out.println(s);
    }

}

@Override
public void add() {
    Boolean check = true;
    while (true) {
        try {
            System.out.println("Nhập biển số xe: ");
            String bienSo = scanner.nextLine();
            System.out.println("Nhập tên chủ xe: ");
            String chuXe = scanner.nextLine();
            System.out.println("Nhập năm sản xuất: ");
            Integer namSX = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập nhãn hiệu của xe: ");
            String nhanHieu = scanner.nextLine();
            System.out.println("Nhập dung tích của xe: ");
            Integer dungTich = Integer.parseInt(scanner.nextLine());
            check = false;
            Motor newMotor = new Motor(bienSo, chuXe, namSX, nhanHieu, dungTich);
            motorBikeList.add(newMotor);
            break;
        } catch (Exception e) {
            System.out.println("Nhập sai định dạng. Vui lòng nhập lại");
            check = true;
        }
    }

}

@Override
public void edit() {
    int index =-1;
    System.out.println("Nhập biển số muốn sửa: ");
    String findPlate = scanner.nextLine();
    for (int i = 0; i< motorBikeList.size(); i++){
        if (findPlate.equals(motorBikeList.get(i).getLicensePlate())){
            Boolean check = true;
            while (true){
                try {
                    motorBikeList.get(i).setLicensePlate(findPlate);
                    System.out.println("Nhập lại tên chủ xe: ");
                    motorBikeList.get(i).setNameOwner(scanner.nextLine());
                    System.out.println("Nhập lại năm sản xuất: ");
                    motorBikeList.get(i).setYearOfManufacture(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Nhập nhãn hiệu của xe: ");
                    motorBikeList.get(i).setBrand(scanner.nextLine());
                    System.out.println("Nhập dung tích của xe: ");
                    motorBikeList.get(i).setCapacity(Integer.parseInt(scanner.nextLine()));
                    check = false;
                    break;
                } catch (Exception e) {
                    System.out.println("Nhập sai định dạng. Vui lòng nhập lại");
                    check = true;
                }
            }
            index = 1;
        }
    }if (index == -1){
        System.out.println("Không tìm thấy");}


}

@Override
public void delete() {

}

@Override
public void searchByName() {
    int index =-1;
    System.out.println("Nhập biển số muốn tìm: ");
    String findName = scanner.nextLine();
    for (int i = 0; i< motorBikeList.size(); i++){
        if (findName.equals(motorBikeList.get(i).getLicensePlate())){
            index = 1;
            System.out.println(motorBikeList.get(i));
        }
    }if (index == -1){
        System.out.println("Không tìm thấy");
    }
}

}
