package Docs;

public class Prikaz extends MainDocs {
    String sotrudnik;
    String text;
    int status;
    String uvolen;

    public Prikaz(int num, String name, String sotrudnik, String text, int status) {
        this.sotrudnik = sotrudnik;
        this.text = text;
        this.status = status;
        this.nameDoc = name;
        this.numberDoc = num;
    }

    public Prikaz(int num, String name, String sotrudnik, String text, int status, String uvolen) {
        this.sotrudnik = sotrudnik;
        this.text = text;
        this.status = status;
        this.nameDoc = name;
        this.numberDoc = num;
        this.uvolen = uvolen;
    }

    public String getSotrudnik() {
        return sotrudnik;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (this.status == 1) {
            System.out.println("Невозможно поменять статус Исполнен");
        } else {
            this.status = status;
        }

    }

    public void setText(String text) {
        this.text = text;
    }

    public String statusToString(){
        if (status == 0){
            return "Создан";
        } else if (status == 1) {
            return "Исполнен";
        }

        return " ";
    }

    public String log(){
        String text = "Был создан приказ под номером " + numberDoc +
                " имя письма " + nameDoc +
                " сотрундник " + sotrudnik +
                " текст приказа " + this.text +
                " статус приказа " + statusToString();

        return text;
    }

    public String log(String uvolen){
        String text = "Был создан приказ под номером " + numberDoc +
                " имя письма " + nameDoc +
                " сотрундник " + sotrudnik +
                " текст приказа " + this.text +
                " причина увольнения " + this.uvolen +
                " статус приказа " + statusToString();

        return text;
    }





}

