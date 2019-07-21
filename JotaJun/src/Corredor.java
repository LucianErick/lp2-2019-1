import java.util.Objects;

public class Corredor {

    private String nome;
    private String codigo;

    public Corredor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corredor corredor = (Corredor) o;
        return Objects.equals(codigo, corredor.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
