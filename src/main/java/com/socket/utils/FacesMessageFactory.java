package com.socket.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by khayapro on 2016/04/11
 */
public class FacesMessageFactory {

    public void showSuccessMessage(String successMessage){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, successMessage,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showErrorMessage(String errorMessage){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
