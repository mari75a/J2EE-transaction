package lk.jiat.ee.jta.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      EntityManagerFactory factory= Persistence.createEntityManagerFactory("JTAPU");
      EntityManager em= factory.createEntityManager();

      Query query=em.createNativeQuery("select * from user");
      List<Object[]> list=query.getResultList();
      list.forEach( li->{
            System.out.println(li[0] + " "+ li[1] +" "+ li[2]);
        });
        System.out.println(list);
    }
}
