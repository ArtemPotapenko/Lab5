package RouteDir;



public abstract class  Location implements Comparable<Location>{
        public Location(){};
        public abstract String getAll();

    @Override
    public int compareTo(Location o) {
        return this.hashCode()-o.hashCode();
    }


}

