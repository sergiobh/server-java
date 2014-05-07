package sysfrota.web.filter;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import sysfrota.persistence.JPAUtil;

@WebFilter(urlPatterns = "/*")
public class OpenSessionAndTransactionInView implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            chain.doFilter(request, response);
            tx.commit();
        } catch (Exception e) { // ou em caso de erro faz o rollback
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServletException(e);
        } /*finally {
               if(em.isOpen()){
                   em.close();
               }
        }*/
    }

    @Override
    public void destroy() {
        JPAUtil.close();
    }
}
