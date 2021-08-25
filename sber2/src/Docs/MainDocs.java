package Docs;

public class MainDocs {
    int numberDoc;
    String nameDoc;

    public int getNumberDoc() {
        return numberDoc;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public String simpleLog(){
        String simpleLogText = "Было создано письмо под номером " + numberDoc +
                " имя документа " + nameDoc;
        return simpleLogText;
    }
}
