package RouteDir;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Route implements Comparable<Route> {

        private long id;
        private String name;
        private Coordinates coordinates;
        private java.util.Date creationDate;
        private Location from;
        private Location to;
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
     *
     * @param id
     * create Route
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

        public Route(){
            System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя (непустое):");
            name=in.nextLine();
            while (name.length()==0 || ",".contains(name)){
                System.out.println("Введите НЕПУСТОЕ имя:");
                name=in.nextLine();
            }
            System.out.println("Введите координаты");
            coordinates=new Coordinates();
            System.out.println("Выдерете вариант задания локации, их которой строится маршрут ");
            System.out.println("   IntLocation(для ввода целых координат)");
            System.out.println("   FloatLocation(для ввода дробных координат)");
           String check;
            while( true){
                check=in.nextLine();
                if (Pattern.compile("IntLocation").matcher(check).matches()){from = new IntLocation();
                    break;}
                else if (Pattern.compile("FloatLocation").matcher(check).matches()){from = new FloatLocation();break;} else if(check.equals("")){
                    from=null;
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
        try{ t=in.nextLong();}
        catch (InputMismatchException e){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Long getDistance() {
        return distance;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Route o) {
        return name.compareTo(o.name);
    }
}

