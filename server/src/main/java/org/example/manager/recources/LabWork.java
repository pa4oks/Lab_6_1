package org.example.manager.recources;
//import static Comand.base.CollectionManager.priorityQueue;

import com.google.gson.annotations.SerializedName;
import org.example.recources.Coordinates;
import org.example.recources.Difficulty;
import org.example.recources.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LabWork implements Comparable<LabWork> {
    @Override
    public int compareTo(LabWork other) {
        return this.getName().compareTo(other.getName());
    }
    @SerializedName("id")
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @SerializedName("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @SerializedName("coordinates")
    private Coordinates coordinates; //Поле не может быть null
    @SerializedName("creationDate")
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @SerializedName("minimalPoint")
    private Double minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    @SerializedName("difficulty")
    private Difficulty difficulty; //Поле может быть null
    @SerializedName("author")
    private Person author; //Поле может быть null

    public String getLocationString() {
        if (coordinates == null) {
            return "0.0_0.0";
        }
        return coordinates.getX() + "_" + coordinates.getY();
    }

    public LabWork() {
        this.id = generateUniqueLongId();
        this.creationDate = new Date();
    }

    public void ShowLabWork(LabWork labWork) {
        System.out.println("Name: " + labWork.getName());
        System.out.println("ID: " + labWork.getId());
        System.out.println("Coordinates: " + labWork.getCoordinates().getX() + " " + labWork.getCoordinates().getY());
        System.out.println("CreationDate: " + labWork.getCreationDate());
        System.out.println("MinimalPoint: " + labWork.getMinimalPoint());
        System.out.println("Difficulty: " + labWork.getDifficulty());
        System.out.println("Author: " + labWork.getAuthor().getName() + "\n   eyes: " + labWork.getAuthor().getEyeColor() + "\n   hair: " + labWork.getAuthor().getHairColor() + "\n   location: " + labWork.getAuthor().getLocation().getName() + "\n   coordinates: " + labWork.getAuthor().getLocation().getX() + " " + labWork.getAuthor().getLocation().getY() + " " + labWork.getAuthor().getLocation().getZ() + " " + "\n   nationality: " + labWork.getAuthor().getNationality() + "\n   weight: " + labWork.getAuthor().getWeight());
    }

    public long getId() {
        return id;
    }

    /*public void newId() {
        this.id = generateUniqueLongId();;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if (name == null) {
            throw new IllegalAccessException("name");
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Double getMinimalPoint() {
        return minimalPoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Person getAuthor() {
        return author;
    }
    /*public class Builder{
        private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name = "LabWork"; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Double minimalPoint = 1.0; //Поле может быть null, Значение поля должно быть больше 0
        private Difficulty difficulty = Difficulty.NORMAL; //Поле может быть null
        private Person author;

        public Builder(long id) {
            this.id = id;
        }*/

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setMinimalPoint(Double minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }


    public void print() {
        System.out.println("Name: " + getName());
        System.out.println("Coordinates: " + getCoordinates());
        System.out.println("CreationDate: " + getCreationDate());
        System.out.println("MinimalPoint: " + getMinimalPoint());
        System.out.println("Difficulty: " + getDifficulty());
        System.out.println("Author: " + getAuthor());
    }

    //}
    public static LabWork ReadLabWork(String string) throws IllegalAccessException {
        String[] readings = string.split(" ");
        //как задать через строку, если есть Person??
        LabWork newLabWork = null;
        newLabWork.generateUniqueLongId();


        return newLabWork;
    }

    static List<Integer> idList = new ArrayList<>();

    private static final Random random = new Random();


    public static long generateUniqueLongId() {
        long newId;
        newId = generateRandomLongId();
        boolean flag = true;
        do {
            flag = true;
            for (int i = 0; i < idList.size(); i++) {
                if (newId == idList.get(i)) {
                    flag = false;
                }
            }
        } while (!flag);
        return newId;
    }

    private static long generateRandomLongId() {
        return Math.abs(random.nextLong());  // Генерируем неотрицательное случайное long число
    }

    /*@Override
    public int compareTo(LabWork other) {
        // Сортируем по приоритету (по возрастанию) - это naturalOrder
        return Integer.compare(this.priority, other.priority);
    }*/

}

