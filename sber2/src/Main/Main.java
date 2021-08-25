package Main;

import Docs.Pismo;
import Docs.Prikaz;

public class Main {

    public static void main (String[] args){

        Pismo pismo = new Pismo(1, "письмо1", "Кому-то", "От того");
        Prikaz priem = new Prikaz(2, "Приём на работу", "Новый сотрудний", "Текст приказа", 0);
        Prikaz uvolnenie = new Prikaz(3, "увольнение", "Новый сотрудний", "Текст приказа", 0, "Захотел");

        //Сделал наверное немного неправильно хотелось бы про параметры ещё поговорить
        if (!args[0].equals("simple")){
        System.out.println(pismo.log());
        System.out.println(priem.log());
        System.out.println(uvolnenie.log("да"));
        } else {

            System.out.println(pismo.simpleLog());
            System.out.println(priem.simpleLog());
            System.out.println(uvolnenie.simpleLog());
        }

        priem.setStatus(1);
        uvolnenie.setStatus(1);

        if (args[0].equals("simple")) {
            System.out.println("Вывод после смены статуса");
            System.out.println(priem.log());
            System.out.println(uvolnenie.log("да"));
        } else {
            System.out.println("Вывод после смены статуса");
            System.out.println(priem.simpleLog());
            System.out.println(uvolnenie.simpleLog());
        }
    }

}
