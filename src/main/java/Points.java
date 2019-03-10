import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "points")
@SessionScoped
public class Points extends ArrayList {
    static Points pl;

    public Points() {
    }

    static boolean match(double x, double y, double r) {
        return (x >= 0 && y >= 0 && (x * x + y * y) <= r * r) ||
                (x >-r && y < r && y >= 0 && x < 0) ||
                (x > 0 && y < 0 && y > x - r / 2);
    }

    public static void addResult(Point p) {
        double x;
        double y;
        double r;
        try {
            x = Double.parseDouble(p.getX().replace(',', '.'));
            y = Double.parseDouble(p.getY().replace(',', '.'));
            r = Double.parseDouble(p.getR().replace(',', '.'));
        } catch (Exception e) {
            return;
        }

        boolean check = match(x, y, r);
        pl.add(p);
    }
}
