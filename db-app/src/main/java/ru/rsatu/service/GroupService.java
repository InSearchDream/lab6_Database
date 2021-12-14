package ru.rsatu.service;

import ru.rsatu.pojo.Group;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GroupService {

    @Inject
    EntityManager entityManager;

    /*
     * Метод вставки
     */
    @Transactional // обязательная аннотация для методов, которые вносят изменения в БД
    public Group insertGroup (Group group){
        entityManager.persist(group);
        entityManager.flush();
        return  group;
    }

    /*
     * Метод обновления
     */
    @Transactional
    public Group updateGroup (Group group){
        entityManager.merge(group);
        entityManager.flush();
        return  group;
    }
    /*
     * Метод удаления
     */
    @Transactional
    public void deleteGroup (Group group) {
        Group g = getGroupById(group.getId());
        entityManager.remove(g);
        entityManager.flush();
    }
    /*
     * Получение списка
     */

    public List<Group> getGroups(){
        return entityManager.createQuery("select g from Group g", Group.class).getResultList();
    }

    /*
     * Поиск по ID
     */
    public Group getGroupById(Long id){
        Group group = entityManager.find(Group.class, id);
        return group;
    }

}
