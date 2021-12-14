package ru.rsatu.service;

import ru.rsatu.pojo.Trainer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TrainerService {

    @Inject
    EntityManager entityManager;

    /*
     * Метод вставки
     */
    @Transactional // обязательная аннотация для методов, которые вносят изменения в БД
    public Trainer insertTrainer (Trainer trainer){
        entityManager.persist(trainer);
        entityManager.flush();
        return  trainer;
    }

    /*
     * Метод обновления
     */
    @Transactional
    public Trainer updateTrainer (Trainer trainer){
        entityManager.merge(trainer);
        entityManager.flush();
        return  trainer;
    }
    /*
     * Метод удаления
     */
    @Transactional
    public void deleteTrainer (Trainer trainer) {
        Trainer t = getTrainerById(trainer.getId());
        entityManager.remove(t);
        entityManager.flush();
    }
    /*
     * Получение списка
     */

    public List<Trainer> getTrainers(){
        return entityManager.createQuery("select t from Trainer t", Trainer.class).getResultList();
    }

    /*
     * Поиск по ID
     */
    public Trainer getTrainerById(Long id){
        Trainer trainer = entityManager.find(Trainer.class, id);
        return trainer;
    }

}
