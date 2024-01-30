package entity;

public class AdminEntity {
        String username;
        String password;


        public AdminEntity(String username, String password){
            this.username = username;
            this.password = password;

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

}
