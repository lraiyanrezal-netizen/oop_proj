import java.util.ArrayList;

public class NoticeBoard {
    ArrayList<String> newsList;
    String InchargeName;

    public NoticeBoard(){}
    public NoticeBoard(String InchargeName) {
        this.InchargeName = InchargeName;
        this.newsList = new ArrayList<>();
    }


    public void display() {
        System.out.println("Notice Board");
        if (newsList.isEmpty()) {
            System.out.println("There is no News");
        } else {
            for (int i = 0; i < newsList.size(); i++) {
                System.out.println((i + 1) + "- " + newsList.get(i));
            }
        }
    }


    public void addContent(String content) {
        this.newsList.add(content);
        System.out.println("Content Added");
    }
}
