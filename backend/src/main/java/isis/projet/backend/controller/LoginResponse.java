package isis.projet.backend.controller;

public class LoginResponse {
    private String token;


    public LoginResponse(String token, String email) {
        this.token = token;

    }

    public String getToken() {
        return token;
    }


}
