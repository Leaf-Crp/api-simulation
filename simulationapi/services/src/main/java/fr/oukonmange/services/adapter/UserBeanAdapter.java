package fr.oukonmange.services.adapter;

import fr.oukonmange.beans.common.UserBean;
import fr.oukonmange.data.entity.User;

public class UserBeanAdapter {

    private UserBeanAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static UserBean transform(User user){
        UserBean userBean = new UserBean();
        userBean.setNom(user.getNomUser());
        userBean.setPrenom(user.getPrenomUser());
        userBean.setPseudo(user.getPseudoUser());
        return userBean;
    }
}
