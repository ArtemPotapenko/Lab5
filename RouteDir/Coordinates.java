package RouteDir;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Coordinates {
    private long x;
    private Double y;
    public Coordinates(){
        x=ReadX();
        y=ReadY();
    }
    public Coordinates(long x,Double y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return read x from cons: [-2^63;2^63-1] - coordinate , type: long.
     */
    private long ReadX() {
        long t;
        System.out.println("Введите координату x - Целое число. -2^63≤x≤2^63-1");
        Scanner in = new Scanner(System.in);
        try{ t=in.nextLong();}
        catch (InputMismatchException e){
            System.out.println("Ошибочный ввод");
          t=ReadX();
        }
        return t;
    }

    /**
     * @return read y from cons: [-2^1024;2^1024-1], about 100 characters after the dot. - coordinate , type: double.
     */
    private double ReadY(){
        double t;
        System.out.println("Введите координату y - десятичную дробь. -2^1024≤2^1024-1.  ");
        Scanner in = new Scanner(System.in);
        try{ t=in.nextDouble();}
        catch (InputMismatchException e){
            System.out.println("Ошибочный ввод");
            t=ReadY();
        }
        return t;
    }

    public Double getY() {
        return y;
    }

    public long getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
