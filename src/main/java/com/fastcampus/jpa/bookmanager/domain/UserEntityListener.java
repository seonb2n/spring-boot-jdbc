package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.repository.UserHistoryRepository;
import com.fastcampus.jpa.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
