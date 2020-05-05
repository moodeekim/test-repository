package woody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain  {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

         EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try {

            Member member = new Member();
            member.setId(3L);
            member.setName("무디");

            entityManager.persist(member);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close(); //엔티티 매니저가 내부적으로 데이터베이스 커넥션을 포함하고 동작하기 때문에 꼭 닫아줘야한다.
        }
        entityManagerFactory.close();


    }
}
