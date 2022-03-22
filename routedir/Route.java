package routedir;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс элементов коллекции.
 * @version 1.0
 */
public class Route implements Comparable<Route> {


    /**
     * Id элепмента. Его уникальный номер
     */
    private long id;
    /**
     * Имя элемента
     */
    private String name;
    /**
     * Координаты пути
     */
    private Coordinates coordinates;
    /**
     * Дата создания маршрута.
     */
    private java.util.Date creationDate;
    /**
     * Локация отъезда.
     */
    private Location from;
    /**
     * Локация приезда.
     */
    private Location to;
    /**
     * Пройденная дистанция.
     */
    private Long distance;
        public Route(long id,java.util.Date creationDate,Coordinates coordinates,String name,Location from, Location to, Long distance){
            this.id= id;
            this.name =name;
            this.coordinates=coordinates;
            this.creationDate = creationDate;
            this.from=from;
            this.to = to;
            this.distance = distance;
        }

    /**
     * Конструтктор для создания элемента по заданному id.
     * @param id id элемента
     *
     */
    public Route(long id){
            Route route=new Route();
            this.id = id;
            name=route.getName();
            coordinates=route.getCoordinates();
            creationDate=route.getCreationDate();
            from=route.getFrom();
            to=route.getTo();
            distance=route.getDistance();
        }


    /**
     * Конструктор для созданяи объяета с генерацией id.
     */
    public Route(){
        System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя (непустое):");
            name=in.nextLine();
            while (name.trim().length()==0 || ",".contains(name)){
                System.out.println("Введите НЕПУСТОЕ имя:");
                name=in.nextLine();
            }
            System.out.println("Введите координаты");
            coordinates=new Coordinates();
            System.out.println("Выдерете вариант задания локации, их которой строится маршрут (или путой)");
            System.out.println("   IntLocation(для ввода целых координат)");
            System.out.println("   FloatLocation(для ввода дробных координат)");
           String check;
            while( true){
                check=in.nextLine();
                if (Pattern.compile("IntLocation").matcher(check).matches()){from = new IntLocation();
                    break;}
                else if (Pattern.compile("FloatLocation").matcher(check).matches()){from = new FloatLocation();break;} else if(check.trim().equals("")){
                    from=null;

                    System.out.println("Локации, из которой строится маршрут пустое");
                    break;
                }
                else {
                    System.out.println("Ошибка ввода. Выберете из двух вариантов.");
                }
            }
            System.out.println("Выдерете вариант задания локации, в которую строится маршрут ");
            System.out.println("   IntLocation(для ввода целых координат)");
            System.out.println("   FloatLocation(для ввода дробных координат)");

            while( true){
                check=in.nextLine();
                if (Pattern.compile("IntLocation").matcher(check).matches()){to = new IntLocation();
                    break;}
                else if (Pattern.compile("FloatLocation").matcher(check).matches()){to = new FloatLocation();break;}
                else {
                    System.out.println("Ошибка ввода. Выберете из двух вариантов.");
                }
            }
            distance = ReadDistance();

            creationDate=new Date();

        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(name, route.name) && Objects.equals(coordinates, route.coordinates) && Objects.equals(creationDate, route.creationDate) && Objects.equals(from, route.from) && Objects.equals(to, route.to) && Objects.equals(distance, route.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, creationDate, from, to, distance);
    }
    public  long ReadDistance(){
        long t;
        System.out.println("Введите дистанцию - Целое число. -2^63≤x≤2^63-1");
        Scanner in = new Scanner(System.in);
        try{ t=Long.parseLong(in.nextLine());}
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Ошибочный ввод");
            t=ReadDistance();
        }
        return t;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }


    /**
     *
     * @return Имя
     */
    public String getName() {
        return name;
    }


    /**
     * Задание имени
     * @param name Имя
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Задание коордтинат
     * @param coordinates Координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    /**
     * Задание даты
     * @param creationDate Дата
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Задание дистанции
     * @param distance Дистация
     */
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    /**
     * Задания локации выезда
     * @param from Локация выезда
     */
    public void setFrom(Location from) {
        this.from = from;
    }

    /**
     * Задание id
     * @param id id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Задание локации приезда
     * @param to локация приезда
     */
    public void setTo(Location to) {
        this.to = to;
    }

    /**
     *
     * @return Координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @return Дата
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @return Локация выезда
     */
    public Location getFrom() {
        return from;
    }

    /**
     *
     * @return Локация приезда
     */
    public Location getTo() {
        return to;
    }

    /**
     *
     * @return Дистанция
     */
    public Long getDistance() {
        return distance;
    }

    /**
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Route o) {
        return name.compareTo(o.name);
    }

    /**
     * Вывод элемента
     */
    public void ShowPrint(){

        System.out.println("Имя:  "+ name);
        System.out.println("  Id: " + id);
        System.out.println("  Координата x: "+coordinates.getX());
        System.out.println("  Координата Y:" + coordinates.getY());
        try{
        System.out.println("  Локация, из которой совершается путь :"+getFrom().getClass() + ". Данные: "+getFrom().getAll());}
        catch (NullPointerException e){
            System.out.println("  Локация, из которой совершается путь : null");
        }
        System.out.println("  Локация, в которую совершается путь :"+getTo().getClass() + ". Данные: "+getTo().getAll());
        System.out.println("  Дата: "+creationDate);
        System.out.println("  Дистанция:"+ distance);
        System.out.println();
    }
}

