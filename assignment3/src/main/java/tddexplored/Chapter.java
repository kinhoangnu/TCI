package tddexplored;

public class Chapter implements Comparable<Chapter>{
    private String name;

    public String getNumber() {
        return number;
    }

    private String number;

    public void setName(String name) throws IllegalArgumentException{
        if(name == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setNumber(String number) throws IllegalArgumentException {
        int count = 0;
        for (int i= 0; i < number.length(); i++) {
                if(number.charAt(i) == '.'){
                    count++;
                }
        }
        if(count > 1){
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Chapter(String name, String number) {
        setName(name);
        setNumber(number);
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Chapter c) {
        return (Double.compare(Double.parseDouble(number),Double.parseDouble(c.getNumber())));
    }
}
