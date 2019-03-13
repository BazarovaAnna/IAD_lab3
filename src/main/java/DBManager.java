import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DBManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String x =req.getParameter("xvalue");
        String y =req.getParameter("yvalue");
        String r =req.getParameter("rvalue");

        Point p=new Point();
        p.setR(r);
        p.setX(x);
        p.setY(y);
        p.setHit();
        PointsDB.add(p);
        resp.getWriter().write("added to db");
    }
}
