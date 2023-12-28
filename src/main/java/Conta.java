import java.io.Serializable;
import java.util.Objects;

public class Conta implements Serializable{
    private String site;
    private String email;
    private String senha;

    public Conta (String site,String email, String senha) {
        this.site = site;
        this.email = email;
        this.senha = senha;
    }

    public Conta () {
        this("","","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(site, conta.site) && Objects.equals(email, conta.email) && Objects.equals(senha, conta.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, email, senha);
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return this.site;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public String toString() {
        return "Site: " + this.site +
                "\nEmail: " + this.email +
                "\nSenha: " + this.senha;
    }
}
