package Docs;

public class Pismo extends MainDocs {
    String toWhom;
    String fromWhom;

    public Pismo(int num, String name, String toWhom, String fromWhom) {
        this.toWhom = toWhom;
        this.fromWhom = fromWhom;
        this.numberDoc = num;
        this.nameDoc = name;
    }

    public String getToWhom() {
        return toWhom;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String log(){
       String text = "Было создано письмо под номером " + numberDoc +
                " имя письма " + nameDoc+
                " кому " + toWhom+
                " от кого " +fromWhom;

       return text;
    }

    @Override
    public String toString() {
        return "Pismo{" +
                "toWhom='" + toWhom + '\'' +
                ", fromWhom='" + fromWhom + '\'' +
                ", numberDoc=" + numberDoc +
                ", nameDoc='" + nameDoc + '\'' +
                '}';
    }
}
