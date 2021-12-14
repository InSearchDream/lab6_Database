package ru.rsatu.service;

import ru.rsatu.pojo.Child;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ChildService {

    @Inject
    EntityManager entityManager;

    /*
     * Метод вставки
     */
    @Transactional // обязательная аннотация для методов, которые вносят изменения в БД
    public Child insertChild (Child child){
        entityManager.persist(child);
        entityManager.flush();
        return  child;
    }

    /*
     * Метод обновления
     */
    @Transactional
    public Child updateChild (Child child){
        entityManager.merge(child);
        entityManager.flush();
        return  child;
    }
    /*
     * Метод удаления
     */
    @Transactional
    public void deleteChild (Child child) {
        Child ch = getChildById(child.getId());
        entityManager.remove(ch);
        entityManager.flush();
    }
    /*
     * Получение списка
     */

    public List<Child> getChilds(){
        return entityManager.createQuery("select ch from Child ch", Child.class).getResultList();
    }

    /*
     * Поиск по ID
     */
    public Child getChildById(Long id){
        Child child = entityManager.find(Child.class, id);
        return child;
    }

}
