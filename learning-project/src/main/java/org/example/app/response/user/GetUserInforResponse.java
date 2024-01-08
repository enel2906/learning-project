package org.example.app.response.user;

import org.example.app.model.dto.UserDTO;
import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@ResponseBody
public class GetUserInforResponse extends ResponseData {
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public GetUserInforResponse(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
