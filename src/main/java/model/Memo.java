package model;

public class Memo {
    private int id;
    private String title;

    public Memo() {}

    public Memo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // ゲッター
    public int getMemoId() { return id; }
    public String getTitle() { return title; }

 
    public void setMemoId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
}