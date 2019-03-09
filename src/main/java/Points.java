import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "MyPoints")
@SessionScoped
public class Points extends  ArrayList{}