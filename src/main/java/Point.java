import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "Point")
@SessionScoped
public class Point implements Serializable {
    private String r;
    private String x;
    private String y;

    public Point() {
        System.out.println("Starting Point...");

    }


    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getR() {
        return r;
    }



    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setR(String r) {
        this.r = r;
    }


    private String getSayCoords() {
        if ("".equals(r) || r == null || "".equals(y) || y == null || "".equals(x) || x == null) {
            //check if null?
            return "";
        } else {

            return "Ajax message : Welcome, friend! Your data is: \nR: " + r + "\nX: " + x + "\nY: " + y;
        }
    }

    public String getShowCurrent() {
        if (("".equals(r) || r == null) && ("".equals(y) || y == null) && ("".equals(x) || x == null)) {
            return "";
        } else {
            if (("".equals(y) || y == null) && ("".equals(x) || x == null)) {
                return "R: " + r;
            } else {
                if (("".equals(r) || r == null) && ("".equals(x) || x == null)) {
                    return "Y: " + y;
                } else {
                    if (("".equals(r) || r == null) && ("".equals(y) || y == null)) {
                        return "X: " + x;
                    } else {
                        if (("".equals(r) || r == null)) {
                            return "X: " + x + "\nY: " + y;
                        } else {
                            if (("".equals(x) || x == null)) {
                                return "R: " + r + "\nY: " + y;
                            } else {
                                if (("".equals(y) || y == null)) {
                                    return "R: " + r + "\nX: " + x;
                                } else {
                                    return getSayCoords();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}