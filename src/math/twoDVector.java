package math;

public class twoDVector {

    private double x,y;

    public twoDVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public twoDVector(){
        x = 0;
        y = 0;
    }

    public twoDVector add(twoDVector v){
        return new twoDVector(x + v.getX(), y + v.getY());
    }

    public twoDVector scale(double value){
        return new twoDVector(x * value, y * value);
    }

    public void limit(double value){


        if(x > value )
            x = value;
        if(x < -value)
            x = -value;

        if(y > value )
            y = value;
        if(y < -value)
            y = -value;

    }
    public twoDVector normalize(){

        return new twoDVector(x / getMagnitude(), y / getMagnitude());
    }

    public double getMagnitude(){
        return Math.sqrt(x*x + y*y);
    }

    public twoDVector setDirection(double angle){
        return new twoDVector(Math.cos(angle)*getMagnitude(), Math.sin(angle)*getMagnitude());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
