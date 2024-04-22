package org.example;

public class Book {
    //properties
    private int id;
    private String isbm;
    private String title;
    private boolean isCheckout;
    private String checkOutTo;

    //constructor
    public Book(int id, String isbm, String title, boolean isCheckout, String checkOutTo) {
        this.id = id;
        this.isbm = isbm;
        this.title = title;
        this.isCheckout = isCheckout;
        this.checkOutTo = checkOutTo;
    }

    public Book(int id, String isbm, String title) {
        this.id = id;
        this.isbm = isbm;
        this.title = title;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    //methods
    public void checkOut(String name, int bookId){
        isCheckout = true;
        checkOutTo = name;
        id = bookId;
    }

    public void checkIn(){
        if(isCheckout){
            isCheckout = false;
            checkOutTo = "";

        }
    }
}
