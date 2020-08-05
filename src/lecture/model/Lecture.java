package lecture.model;

public class Lecture {
    
    private int id;
    private String name;
    private boolean math;
    private boolean english;
    private boolean composition;
    private boolean science;
    
    public Lecture(int id,String name, boolean math, boolean english, boolean composition, boolean science) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.composition = composition;
        this.science = science;
    }

    public int getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }
   
    public boolean isMath() {
        return math;
    }
 
    public boolean isEnglish() {
        return english;
    }
  
    public boolean isComposition() {
        return composition;
    }
   
    public boolean isScience() {
        return science;
    }
}
