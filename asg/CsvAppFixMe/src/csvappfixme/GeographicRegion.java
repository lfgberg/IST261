package csvappfixme;

public class GeographicRegion {
    private String country, area;

    public GeographicRegion(String country, String area){
        this.country = country;
        this.area = area;
    }
    
    @Override
    public String toString(){
        return String.format("name: %s; area: %s", country, area);
    }
}
