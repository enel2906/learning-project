package models;

public abstract class HistoryAbstract {
    private String id;
    private String name;

    public abstract void hyperLInk();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){return name;}

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
