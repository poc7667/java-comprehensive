package com.company;

/**
 * Created by poc on 8/7/16.
 */
public class Movie implements Comparable{
    private String title=null;
    private String category=null;
    public Movie(String title, String category){
        this.title = title;
        this.category = category;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Movie){
            Movie i = (Movie) o;
            int compare = this.title.compareTo(i.title);
            return compare;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
