public class GradeService {
    private double average;
    double finalGrade;
    double status;
    double a, b, c;

    GradeService(double p1, double p2, double p3){
        this.a = p1;
        this.b = p2;
        this.c = p3;
    }

    public void setAverage(){
        this.average = (this.a + this.b + this.c) / 3;
    }

    public double getAverage(){
        return this.average;
    }


}
