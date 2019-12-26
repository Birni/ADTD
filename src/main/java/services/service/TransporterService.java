package services.service;

import services.entity.Transporter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class TransporterService
{
    @PersistenceContext(unitName="adtd_db")
    private EntityManager em;

    @Transactional
    public Transporter addTransporter(Transporter transporter) {

        em.persist(transporter);

        return transporter;
    }


    @Transactional
    public Transporter deleteTransporter(Transporter transporter) {

        em.remove(transporter);

        return transporter;
    }

    public void editStudentData(Transporter transporter) {
        Transporter original = em.find(Transporter.class, transporter.getId());
        original.setBattery(transporter.getBattery());
        original.setPayload(transporter.getPayload());

        em.persist(transporter);
    }


    public List<Transporter> getAllTransporter() {
        TypedQuery<Transporter> query = em.createQuery(
                "SELECT s FROM Transporter AS s",
                Transporter.class
        );
        return query.getResultList();
    }

}
