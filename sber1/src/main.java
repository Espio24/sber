import com.sun.javaws.IconUtil;

import java.util.Scanner;

public class main {

    // Данные константы
    static double costfuel100=46.10;
    static double costfuel200=48.90;
    static double costfuel300=47.50;
    static double costfuel400=costfuel200;

    static double fuelConsumption100=12.5;
    static double fuelConsumption200=12;
    static double fuelConsumption300=11.5;
    static double fuelConsumption400=20;

    //Считаем стоимость потрачеенного топлива
    public static double fuelcost(double cost,double fuel){
        double fuelcost = cost*fuel;
        return fuelcost;
    }

    //Функция деления строки на части
    public static String[] splitarr (String arr){

            String[] cklass = arr.split("_");
            String klass = cklass[0];
            String[] other = cklass[1].split("-");
            String number = other[0];
            String probeg = other[1];
            String parametr = null;
            if (other.length == 3){
                parametr = other[2];
            } else {
                parametr = " ";
            }

            String[] out = new String[] {klass, number, probeg, parametr};


        return out;
    }

    //Функция обмена местами
    private static void swap(String[] array, int ind1, int ind2) {
        String tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    //Функция сортировки и вывода данных (Так как я реализовал это плохо, сделал так для скорости)
    private static void sortarr(String[] array, int type){
        String ctype = "C" + type;

        // Перебираем значения и суммруем поля, если номер и тип машины совпадает при этом один из элементов массива превращаем в пустое поле
        //P.S. Был ещё вариант просто добавить ещё один массив внутри этой функции и возвращать его. В нём содержались только бы отобранные элементы.
        for (int i=0; i<array.length; i++){
            if (array[i] == " "){
                continue;
            }
            String[] check = splitarr(array[i]);
            for (int j = i+1; j<array.length; j++){
                if (array[j] == " "){
                    continue;
                }
                String[] checkj = splitarr(array[j]);
                if (check[0].equals(checkj[0]) && checkj[1].equals(check[1])){
                    int sum = Integer.parseInt(check[2]) + Integer.parseInt(checkj[2]);
                    String needstr = check[0]+"_" + check[1] + "-" + sum;
                          if (!check[3].equals(" ") && !checkj[3].equals(" ")){
                              int sum3 = Integer.parseInt(check[3]) + Integer.parseInt(checkj[3]);
                              needstr = needstr + "-" + sum3;
                          } else if (!check[3].equals(" ") && checkj[3].equals(" ")){
                              needstr = needstr + "-" + Integer.parseInt(check[3]);
                          } else if (check[3].equals(" ") && !checkj[3].equals(" ")){
                              needstr = needstr + "-" + Integer.parseInt(checkj[3]);
                          }
                    //  System.out.println(needstr);
                    array[i] = needstr;
                    array[j] = " ";
                }

            }
        }

        //сортировка пузырьком
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i=1; i<array.length; i++) {
                if (array[i].equals(" ") || array[i-1].equals(" ")){
                    continue;
                }
                String[] first = splitarr(array[i]);
                String[] second = splitarr(array[i-1]);

                int firstprob = Integer.parseInt(first[2]);
                int secondprob = Integer.parseInt(second[2]);

                if (firstprob < secondprob) {
                    swap(array, i, i-1);
                    needIteration = true;
                }
            }
        }
        //Вывод получившегося массива
        for (int i=0; i<array.length; i++){
            if (array[i] == " "){
                continue;
            }
            String[] check = splitarr(array[i]);
            if (check[0].equals("C"+type)){
                System.out.println(array[i]);
            }
        }
    }

    public static void main (String[] args){
        //задаём массив и переменные для подсчёта
        String[] arr = new String[] {"C100_1-100",
                "C200_1-120-1200",
                "C300_1-120-30",
                "C400_1-80-20",
                "C100_2-50",
                "C200_2-40-1000",
                "C300_2-200-45",
                "C400_2-10-20",
                "C100_3-10",
                "C200_3-170-1100",
                "C300_3-150-29",
                "C400_3-100-28",
                "C100_1-300",
                "C200_1-100-750",
                "C300_1-32-15"};
        double allcost = 0;
        double cost100 = 0;
        double cost200 = 0;
        double cost300 = 0;
        double cost400 = 0;

        System.out.println("Пункт 1 -----------------------------------------------------------------------------------------------------------------------");
        // Считаем стоимость топлива
        for (int i=0; i<arr.length; i++) {
            String[] in = splitarr(arr[i]);
            if (in[0].equals("C100")){
                cost100 += fuelcost(costfuel100, new Integer(in[2]) /100*fuelConsumption100 );
            }
            if (in[0].equals("C200")){
                cost200 += fuelcost(costfuel200, new Integer(in[2]) /100*fuelConsumption200 );
            }
            if (in[0].equals("C300")){
                cost300 += fuelcost(costfuel300, new Integer(in[2]) /100*fuelConsumption300 );
            }
            if (in[0].equals("C400")){
                cost400 += fuelcost(costfuel400, new Integer(in[2]) /100*fuelConsumption400 );
            }

        }

        //Выводим стоимость топлива
        allcost = cost100+cost200+cost300+cost400;
        System.out.println("Общая стоимть ГСМ " + allcost);
        System.out.println("Стоимость ГСМ класс 100 " + cost100);
        System.out.println("Стоимость ГСМ класс 200 " + cost200);
        System.out.println("Стоимость ГСМ класс 300 " + cost300);
        System.out.println("Стоимость ГСМ класс 400 " + cost400);

        System.out.println("Пункт 2 и 3 -----------------------------------------------------------------------------------------------------------------------");
        //Вычисляем  максимум и минимум
        double min = Integer.MAX_VALUE;
        double max = 0;
        int mintype = 0;
        int maxtype = 0;
        double minmaxcost[] = new double[] {cost100, cost200, cost300, cost400};
        for (int i=0; i < minmaxcost.length; i++){
            if(min > minmaxcost[i]){
                min = minmaxcost[i];
                mintype = i+1;
            }
            if (max < minmaxcost[i]){
                max = minmaxcost[i];
                maxtype = i+1;
            }

        }

        System.out.println("Наибольшая стоимость расходов у класса " + maxtype + "00 стоимость " + max);
        System.out.println("Наименьшая стоимость расходов у класса " + mintype + "00 стоимость " + min);

        System.out.println("Пункт 4 -----------------------------------------------------------------------------------------------------------------------");

        //Выбираем тип машины
        int num = 0;
        Scanner in = new Scanner(System.in);

        //Защищаемся от неверных значений
        while (true) {
            System.out.print("Введите номер типа авто(100 200 300 400) ");
            num = in.nextInt();
            int ostatok = num%100;
            if (ostatok == 0 && num<500 && num>0){
                break;
            }
        }
        sortarr(arr, num);

    }
}
